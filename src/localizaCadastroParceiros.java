import javax.swing.*;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class localizaCadastroParceiros extends JFrame {
    public localizaCadastroParceiros() {
        String url = "jdbc:mysql://localhost:3306/unicesumartcc";
        String usuario = "root";
        String senha = "KMvd96ui45!";

        // solicita a entrada do usuário para o nome ou CNPJ a ser pesquisado
        JTextField nomeCnpjField = new JTextField();
        Object[] message = { "Nome ou CNPJ:", nomeCnpjField };
        int option = JOptionPane.showConfirmDialog(null, message, "Pesquisar Cliente", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String nomeCnpj = nomeCnpjField.getText().trim();
            if (nomeCnpj.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, informe um nome ou CNPJ para pesquisar.");
                return;
            }

            // constrói a consulta SQL com base na entrada do usuário
            String sql = "SELECT id, razao_social, cnpj, tipo_parceiro, rua, numero, complemento, bairro, cidade, uf, cep, telefone1, telefone2, email, site, nome_especialista, especialidade FROM parceiros WHERE razao_social LIKE ? OR cnpj = ?";

            // tenta estabelecer a conexão com o banco de dados e executar a consulta
            try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
                    PreparedStatement declaracao = conexao.prepareStatement(sql)) {
                declaracao.setString(1, "%" + nomeCnpj + "%");
                declaracao.setString(2, nomeCnpj);
                ResultSet resultado = declaracao.executeQuery();

                // armazena os dados da consulta em uma matriz de objetos
                Object[][] dados = new Object[100][17]; // supondo que a tabela tenha no máximo 100 linhas
                int linha = 0;
                while (resultado.next()) {
                    dados[linha][0] = resultado.getInt("id");
                    dados[linha][1] = resultado.getString("razao_social");
                    dados[linha][2] = resultado.getString("cnpj");
                    dados[linha][3] = resultado.getString("tipo_parceiro");
                    dados[linha][4] = resultado.getString("rua");
                    dados[linha][5] = resultado.getInt("numero");
                    dados[linha][6] = resultado.getString("complemento");
                    dados[linha][7] = resultado.getString("bairro");
                    dados[linha][8] = resultado.getString("cidade");
                    dados[linha][9] = resultado.getString("uf");
                    dados[linha][10] = resultado.getString("cep");
                    dados[linha][11] = resultado.getString("telefone1");
                    dados[linha][12] = resultado.getString("telefone2");
                    dados[linha][13] = resultado.getString("email");
                    dados[linha][14] = resultado.getString("site");
                    dados[linha][15] = resultado.getString("nome_especialista");
                    dados[linha][16] = resultado.getString("especialidade");
                    linha++;
                }

                // cria um array com os nomes das colunas da tabela
                String[] colunas = { "ID", "Razão Social", "CNPJ", "Tipo", "Rua", "Número", "Complemento",
                        "Bairro", "Cidade", "UF", "CEP", "Telefone 1", "Telefone 2",
                        "Email", "Site", "Nome Especialista", "Especialidade" };

                // cria um JTable com os dados e as colunas especificados
                JTable tabela = new JTable(dados, colunas);

                // cria botões de atualizar e sair
                JButton btnAtualizar = new JButton("Salvar Alterações");
                JButton btnExcluir = new JButton("Excluir");
                JButton btnSair = new JButton("Sair");

                JPanel botoes = new JPanel();
                botoes.add(btnAtualizar);
                botoes.add(btnExcluir);
                botoes.add(btnSair);

                // adiciona o JTable a um JScrollPane
                JScrollPane scrollPane = new JScrollPane(tabela);
                scrollPane.setViewportView(tabela);
                scrollPane.setColumnHeaderView(tabela.getTableHeader());
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                scrollPane.setPreferredSize(new Dimension(1200, 600));

                // cria um painel que contém o JScrollPane e o botão
                JPanel painel = new JPanel(new BorderLayout());
                painel.add(scrollPane, BorderLayout.CENTER);
                painel.add(botoes, BorderLayout.SOUTH);

                // cria um JFrame para exibir o painel
                JFrame frame = new JFrame("Localizar Parceiros");
                frame.getContentPane().add(painel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setVisible(true);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}