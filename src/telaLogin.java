import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class telaLogin extends JFrame {

    public telaLogin() {
        super("SisBras");

        // Carrega a imagem

        ImageIcon sisbrasImageIcon = new ImageIcon(new File("src/img/SISBRASLogo2.png").getAbsolutePath());
        Image sisbrasImage = sisbrasImageIcon.getImage();

        // Redimensiona a imagem
        int newWidth = (int) (sisbrasImage.getWidth(null) * 1.8);
        int newHeight = (int) (sisbrasImage.getHeight(null) * 1.8);
        Image scaledSisbrasImage = sisbrasImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

        // Cria o JLabel e adiciona a imagem
        JLabel labelImagem = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                RoundRectangle2D.Float shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 50, 10);
                g2.clip(shape);
                g2.drawImage(scaledSisbrasImage, 0, 0, getWidth(), getHeight(), null);
                g2.dispose();
            }
        };

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String senha = "";
                String usuario = "";

                Connection connection = null;
                PreparedStatement statement = null;
                ResultSet resultSet = null;

                try {
                    // Carregar o driver
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    // Estabelecer conexão com o banco de dados
                    connection = configMySQL.getInstance().getConnection();

                    // Criar a consulta SQL
                    String sql = "SELECT loginpessoa, senhapessoa FROM parceiros ";

                    statement = connection.prepareStatement(sql);

                    // Executar a consulta
                    resultSet = statement.executeQuery();

                    // Iterar sobre os resultados da consulta
                    boolean loginValido = false;
                    while (resultSet.next()) {
                        usuario = resultSet.getString("loginpessoa");
                        senha = resultSet.getString("senhapessoa");

                        if (textLogin.getText().equals("") || textLogin.getText() == null
                                || textSenha.getPassword().length == 0) {
                            JOptionPane.showMessageDialog(null,
                                    "Por favor preencha os campos solicitados!!");

                            if (textLogin.getText().length() < 6) {
                                JOptionPane.showMessageDialog(null,
                                        "O usuário precisa ter no mínimo 6 caratecteres!!!");
                            } else if (textSenha.getPassword().length < 8) {
                                JOptionPane.showMessageDialog(null, "A senha precisa ter no minimo 8 caratecteres!!!");
                            }
                            break;
                        } else if (textLogin.getText().equals(usuario) &&
                                Arrays.equals(textSenha.getPassword(), senha.toCharArray())) {
                            loginValido = true;
                            dispose();
                            break;
                        }
                    }

                    if (loginValido) {
                        cadastroPessoas cadastroPessoas = new cadastroPessoas();
                        cadastroPessoas.setVisible(true);
                    } else if (!resultSet.isBeforeFirst()) {
                        JOptionPane.showMessageDialog(null, "Usuário e/ou Senha Inválido!!");
                        textLogin.setText("");
                        textSenha.setText("");
                    }

                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                } finally {
                    // Fechar a conexão, o statement e o resultSet
                    try {
                        if (resultSet != null) {
                            resultSet.close();
                        }
                        if (statement != null) {
                            statement.close();
                        }
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Define a posição e o tamanho dos itens
        labelImagem.setBounds(270, 150, newWidth, newHeight);
        usuarioLogin.setBounds(220, 250, newWidth, newHeight);
        textLogin.setBounds(270, 270, 250, 20);
        senhaLogin.setBounds(220, 300, newWidth, newHeight);
        textSenha.setBounds(270, 320, 250, 20);
        btnEntrar.setBounds(345, 400, 90, 30);

        // Define um layout nulo para o JFrame
        setLayout(null);

        // Adiciona o JLabel ao JFrame
        add(usuarioLogin);
        add(textLogin);
        add(senhaLogin);
        add(textSenha);
        add(labelImagem);
        add(btnEntrar);

        // Configura a janela
        setIconImage(sisbrasImageIcon.getImage());
        setSize(800, 600);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    // Cria os componentes
    JLabel usuarioLogin = new JLabel("Usuário:");
    JLabel senhaLogin = new JLabel("Senha:");
    JTextField textLogin = new JTextField();
    JPasswordField textSenha = new JPasswordField();

    public static void main(String[] args) {

    }
}
