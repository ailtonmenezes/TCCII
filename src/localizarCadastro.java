import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class localizarCadastro {
    public static void main(String[] args) {
        // informações de conexão com o banco de dados
        String url = "jdbc:mysql://localhost:3306/unicesumartcc";
        String usuario = "root";
        String senha = "KMvd96ui45!";

        // consulta SQL para recuperar os dados da tabela "clientes"
        String sql = "SELECT id, nome, email, telefone FROM clientes";

        // tenta estabelecer a conexão com o banco de dados
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
                Statement declaracao = conexao.createStatement();
                ResultSet resultado = declaracao.executeQuery(sql)) {

            // armazena os dados da consulta em uma matriz de objetos
            Object[][] dados = new Object[100][4]; // supondo que a tabela tenha no máximo 100 linhas
            int linha = 0;
            while (resultado.next()) {
                dados[linha][0] = resultado.getInt("id");
                dados[linha][1] = resultado.getString("nome");
                dados[linha][2] = resultado.getString("email");
                dados[linha][3] = resultado.getString("telefone");
                linha++;
            }

            // cria um array com os nomes das colunas da tabela
            String[] colunas = { "ID", "Nome", "E-mail", "Telefone" };

            // cria um JTable com os dados e as colunas especificados
            JTable tabela = new JTable(dados, colunas);

            // adiciona o JTable a um JScrollPane
            JScrollPane scrollPane = new JScrollPane(tabela);

            // cria um JFrame para exibir o JScrollPane
            JFrame frame = new JFrame("Exibir Clientes");
            frame.add(scrollPane);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
