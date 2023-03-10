import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class telaLogin extends JFrame {
    public telaLogin() {
        super("SisBras");

        JButton btnLogin = new JButton("Entrar");
        btnLogin.addActionListener(new btnEntrar());

        // Carrega a imagem

        ImageIcon sisbrasImageIcon = new ImageIcon(new File("src/img/SISBRASLogo2.png").getAbsolutePath());
        Image sisbrasImage = sisbrasImageIcon.getImage();

        // Redimensiona a imagem para 80% do tamanho original
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

        // Define a posição e o tamanho do JLabel
        labelImagem.setBounds(270, 150, newWidth, newHeight);
        usuarioLogin.setBounds(220, 250, newWidth, newHeight);
        textLogin.setBounds(270, 270, 250, 20);
        senhaLogin.setBounds(220, 300, newWidth, newHeight);
        textSenha.setBounds(270, 320, 250, 20);
        btnLogin.setBounds(345, 400, 90, 30);
        // Define um layout nulo para o JFrame
        setLayout(null);

        // Adiciona o JLabel ao JFrame
        add(usuarioLogin);
        add(textLogin);
        add(senhaLogin);
        add(textSenha);
        add(labelImagem);
        add(btnLogin);

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
    JButton btnLogin = new JButton("Entrar");

    public static void main(String[] args) {
        telaLogin tLogin = new telaLogin();
        tLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
