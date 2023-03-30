import java.awt.Font;
import java.awt.TextField;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class cadastrarParceiros extends JFrame {
    public cadastrarParceiros() {
        super("Cadastro de Parceiros");
        setSize(800, 600);
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(null);

        // Cria array da caixa de seleção
        String[] opcoes = { "Instituição de Saúde", "Instituição de Trabalho", "Instituição de Educação",
                "Instituição de Moradia" };

        // Cria itens
        Font font = new Font("Arial", Font.BOLD, 30);
        JLabel titulo = new JLabel("Cadastro de Parceiros");
        JLabel labelRazaoSocial = new JLabel("Razão Social:");
        JTextField textRazaoSocial = new JTextField();
        JLabel labelCNPJ = new JLabel("CNPJ:");
        JTextField textCNPJ = new JTextField();
        JComboBox<String> comboBox = new JComboBox<>(opcoes);
        JLabel labelParceiros = new JLabel("Escolha tipo de Parceiro:");
        JLabel labelEndereco = new JLabel("Endereço:");
        JLabel labelRua = new JLabel("Rua:");
        JTextField textRua = new JTextField();

        // Escolhe o tamanho da font
        titulo.setFont(font);

        // Adiciona Itens
        add(titulo);
        add(labelRazaoSocial);
        add(textRazaoSocial);
        add(labelCNPJ);
        add(textCNPJ);
        add(comboBox);
        add(labelParceiros);
        add(labelEndereco);
        add(labelRua);
        add(textRua);

        // Define a posição e o tamanho dos itens
        titulo.setBounds(500, 10, 350, 60);
        labelRazaoSocial.setBounds(50, 100, 80, 50);
        textRazaoSocial.setBounds(128, 117, 300, 20);
        labelCNPJ.setBounds(450, 98, 350, 60);
        textCNPJ.setBounds(500, 117, 300, 20);
        labelParceiros.setBounds(810, 100, 150, 50);
        comboBox.setBounds(810, 140, 300, 20);
        labelEndereco.setBounds(50, 140, 70, 50);
        labelRua.setBounds(50, 180, 70, 20);
        textRua.setBounds(80, 180, 350, 20);
    }

    public static void main(String[] args) {
        cadastrarParceiros cadParceiros = new cadastrarParceiros();
        cadParceiros.setVisible(true);
    }
}
