import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class localizaCadastroPessoa extends JFrame {
    public localizaCadastroPessoa() {
        String url = "jdbc:mysql://localhost:3306/unicesumartcc";
        String usuario = "root";
        String senha = "KMvd96ui45!";

        // solicita a entrada do usuário para o nome ou CPF a ser pesquisado
        JTextField nomeCpfField = new JTextField();
        Object[] message = {
                "Nome ou CPF:", nomeCpfField
        };
        int option = JOptionPane.showConfirmDialog(null, message, "Pesquisar Cliente",
                JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String nomeCpf = nomeCpfField.getText().trim();
            if (nomeCpf.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, informe um nome ou CPF para pesquisar.");
                return;
            }

            // constrói a consulta SQL com base na entrada do usuário
            String sql = "SELECT id_pessoa, nome, rg, cpf, profissao, escolaridade, data_nascimento,sexo,naturalidade,uf,estado_civil,escolar,medico,trabalho,moradia,observacoes FROM pessoa WHERE nome LIKE ? OR cpf = ?";

            // tenta estabelecer a conexão com o banco de dados e executar a consulta
            try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
                    PreparedStatement declaracao = conexao.prepareStatement(sql)) {
                declaracao.setString(1, "%" + nomeCpf + "%");
                declaracao.setString(2, nomeCpf);
                ResultSet resultado = declaracao.executeQuery();

                // armazena os dados da consulta em uma matriz de objetos
                Object[][] dados = new Object[100][16]; // supondo que a tabela tenha no máximo 100 linhas
                int linha = 0;
                while (resultado.next()) {
                    dados[linha][0] = resultado.getInt("id_pessoa");
                    dados[linha][1] = resultado.getString("nome");
                    dados[linha][2] = resultado.getString("rg");
                    dados[linha][3] = resultado.getString("cpf");
                    dados[linha][4] = resultado.getString("profissao");
                    dados[linha][5] = resultado.getString("escolaridade");
                    dados[linha][6] = resultado.getString("data_nascimento");
                    dados[linha][7] = resultado.getString("sexo");
                    dados[linha][8] = resultado.getString("naturalidade");
                    dados[linha][9] = resultado.getString("uf");
                    dados[linha][10] = resultado.getString("estado_civil");
                    dados[linha][11] = resultado.getString("escolar");
                    dados[linha][12] = resultado.getString("medico");
                    dados[linha][13] = resultado.getString("trabalho");
                    dados[linha][14] = resultado.getString("moradia");
                    dados[linha][15] = resultado.getString("observacoes");
                    linha++;
                }

                // cria um array com os nomes das colunas da tabela
                String[] colunas = { "ID", "Nome", "RG", "CPF", "Profissão", "Escolaridade", "Nascimento",
                        "Sexo", "Naturalidade", "UF", "Estado Civil", "Enc.Escola", "Enc.Trabalho",
                        "Enc.Médico", "Enc.Moradia", "Observações" };

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
                JFrame frame = new JFrame("Localizar Pessoas");
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
