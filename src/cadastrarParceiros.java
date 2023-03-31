import java.awt.Font;

import javax.swing.JButton;
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
        JLabel labelParceiros = new JLabel("Escolha o tipo de Parceiro:");
        JLabel labelEndereco = new JLabel("Endereço:");
        JLabel labelRua = new JLabel("Rua:");
        JTextField textRua = new JTextField();
        JLabel labelNumero = new JLabel("Número:");
        JTextField textNumero = new JTextField();
        JLabel labelComplemento = new JLabel("Complemento:");
        JTextField textComplemento = new JTextField();
        JLabel labelBairro = new JLabel("Bairro:");
        JTextField textBairro = new JTextField();
        JLabel labelCidade = new JLabel("Cidade:");
        JTextField textCidade = new JTextField();
        JLabel labelUF = new JLabel("UF:");
        JTextField textUF = new JTextField();
        JLabel labelCEP = new JLabel("CEP:");
        JTextField textCEP = new JTextField();
        JLabel labelContato = new JLabel("Contato:");
        JLabel labelTelefone1 = new JLabel("Telefone 1:");
        JTextField textTelefone1 = new JTextField();
        JLabel labelTelefone2 = new JLabel("Telefone 2:");
        JTextField textTelefone2 = new JTextField();
        JLabel labelEmail = new JLabel("Email:");
        JTextField textEmail = new JTextField();
        JLabel labelSite = new JLabel("Site:");
        JTextField textSite = new JTextField();
        JLabel labelEspecialista = new JLabel("Especialista:");
        JLabel labelNomeEspecialista = new JLabel("Nome Especialista:");
        JTextField textNomeEspecialista = new JTextField();
        JLabel labelEspecialidade = new JLabel("Especialidade:");
        JTextField textEspecialidade = new JTextField();
        JButton btnSalvar = new JButton("Salvar");
        JButton btnLimpar = new JButton("Limpar");
        JButton btnSair = new JButton("Sair");

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
        add(labelNumero);
        add(textNumero);
        add(labelComplemento);
        add(textComplemento);
        add(labelBairro);
        add(textBairro);
        add(labelCidade);
        add(textCidade);
        add(labelUF);
        add(textUF);
        add(labelCEP);
        add(textCEP);
        add(labelContato);
        add(labelTelefone1);
        add(labelTelefone2);
        add(textTelefone1);
        add(textTelefone2);
        add(labelEmail);
        add(textEmail);
        add(labelSite);
        add(textSite);
        add(labelEspecialista);
        add(labelNomeEspecialista);
        add(textNomeEspecialista);
        add(labelEspecialidade);
        add(textEspecialidade);
        add(btnSalvar);
        add(btnLimpar);
        add(btnSair);

        // Define a posição e o tamanho dos itens
        titulo.setBounds(500, 10, 350, 60);
        labelRazaoSocial.setBounds(50, 100, 80, 50);
        textRazaoSocial.setBounds(128, 117, 300, 20);
        labelCNPJ.setBounds(450, 98, 350, 60);
        textCNPJ.setBounds(500, 117, 300, 20);
        labelParceiros.setBounds(810, 100, 170, 50);
        comboBox.setBounds(810, 140, 300, 20);
        labelEndereco.setBounds(50, 140, 70, 50);
        labelRua.setBounds(50, 180, 70, 20);
        textRua.setBounds(80, 180, 350, 20);
        labelNumero.setBounds(450, 180, 50, 20);
        textNumero.setBounds(504, 180, 50, 20);
        labelComplemento.setBounds(560, 180, 100, 20);
        textComplemento.setBounds(650, 180, 300, 20);
        labelBairro.setBounds(50, 210, 70, 20);
        textBairro.setBounds(98, 210, 350, 20);
        labelCidade.setBounds(455, 210, 350, 20);
        textCidade.setBounds(500, 210, 300, 20);
        labelUF.setBounds(805, 210, 50, 20);
        textUF.setBounds(825, 210, 30, 20);
        labelCEP.setBounds(50, 240, 80, 20);
        textCEP.setBounds(80, 240, 80, 20);
        labelContato.setBounds(50, 300, 100, 20);
        labelTelefone1.setBounds(50, 340, 80, 20);
        textTelefone1.setBounds(115, 340, 110, 20);
        labelTelefone2.setBounds(240, 340, 110, 20);
        textTelefone2.setBounds(310, 340, 110, 20);
        labelEmail.setBounds(50, 380, 100, 20);
        textEmail.setBounds(90, 380, 350, 20);
        labelSite.setBounds(445, 380, 80, 20);
        textSite.setBounds(474, 380, 300, 20);
        labelEspecialista.setBounds(50, 420, 100, 20);
        labelNomeEspecialista.setBounds(50, 450, 350, 20);
        textNomeEspecialista.setBounds(165, 450, 350, 20);
        labelEspecialidade.setBounds(530, 450, 350, 20);
        textEspecialidade.setBounds(620, 450, 350, 20);
        btnSalvar.setBounds(400, 600, 100, 20);
        btnLimpar.setBounds(600, 600, 100, 20);
        btnSair.setBounds(800, 600, 100, 20);
    }

    public static void main(String[] args) {
        cadastrarParceiros cadParceiros = new cadastrarParceiros();
        cadParceiros.setVisible(true);
    }
}
