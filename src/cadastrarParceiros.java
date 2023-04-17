import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.*;

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
        JLabel labelCadastrar = new JLabel("Cadastrar Usuário e Senha");
        JLabel labelLogin = new JLabel("Cadastrar Login:");
        JTextField textLogin = new JTextField();
        JLabel labelPassword = new JLabel("Cadastrar Senha:");
        JPasswordField textPassword = new JPasswordField();
        JLabel titulo = new JLabel("Cadastro de Parceiros");
        JLabel labelRazaoSocial = new JLabel("Razão Social:");
        JTextField textRazaoSocial = new JTextField();
        JLabel labelCNPJ = new JLabel("CNPJ:");
        JTextField textCNPJ = new JTextField();
        JComboBox<String> comboBoxTipoParceiro = new JComboBox<>(opcoes);
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
        add(labelCadastrar);
        add(labelLogin);
        add(textLogin);
        add(labelPassword);
        add(textPassword);
        add(labelRazaoSocial);
        add(textRazaoSocial);
        add(labelCNPJ);
        add(textCNPJ);
        add(comboBoxTipoParceiro);
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

        // Criar Menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuCadastro = new JMenu("Cadastros");
        menuBar.add(menuCadastro);

        JMenu cadastro = new JMenu("Localizar");
        menuCadastro.add(cadastro);

        JMenuItem localizarPessoa = new JMenuItem("Localizar Cadastro de Pessoas");
        cadastro.add(localizarPessoa);

        JMenuItem localizarParceiros = new JMenuItem("Localizar Cadastro de Parceiros");
        cadastro.add(localizarParceiros);

        JMenu cadastrarParceiro = new JMenu("Cadastrar");
        menuCadastro.add(cadastrarParceiro);

        JMenuItem novoCadastroPessoa = new JMenuItem("Novo Cadastro de Pessoa");
        cadastrarParceiro.add(novoCadastroPessoa);

        JMenuItem novoCadastroParceiro = new JMenuItem("Novo Cadastro de Parceiro");
        cadastrarParceiro.add(novoCadastroParceiro);

        JMenu menuSobre = new JMenu("Sobre");

        JMenuItem sobreMenuItem = new JMenuItem("SisBras");

        menuSobre.add(sobreMenuItem);

        menuBar.add(menuSobre);

        // Ações do menu

        // Ação do Menu Localizar
        localizarPessoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new localizaCadastroPessoa();
            }
        });
        localizarParceiros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new localizaCadastroParceiros();
            }
        });

        novoCadastroPessoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new cadastroPessoas();
            }
        });

        novoCadastroParceiro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new cadastrarParceiros();
            }
        });
        sobreMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "SisBras\nVersão Beta/Protótipo\nDesenvolvido por Ailton Menezes\nTCCII - Curso: Engenharia de Software\nUnivercidade: Unicesumar\nAno: 2023\nCopyright ©");
            }
        });

        JMenu menuOpcoes = new JMenu("Opções");

        JMenuItem sairMenuItem = new JMenuItem("Sair");

        menuOpcoes.add(sairMenuItem);

        menuBar.add(menuOpcoes);

        sairMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Ação do botão sair
        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela atual
                telaLogin tela = new telaLogin();
                tela.setVisible(true);
            }
        });

        // Ação do botão limpar
        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textRazaoSocial.setText("");
                textCNPJ.setText("");
                textRua.setText("");
                textNumero.setText("");
                textComplemento.setText("");
                textBairro.setText("");
                textCidade.setText("");
                textUF.setText("");
                textCEP.setText("");
                textTelefone1.setText("");
                textTelefone2.setText("");
                textEmail.setText("");
                textSite.setText("");
                textNomeEspecialista.setText("");
                textEspecialidade.setText("");
            }
        });

        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obter o texto digitado nas caixas de texto
                String getUsuario = textLogin.getText();
                String getSenha = new String(textPassword.getPassword());
                String getRazaoSocial = textRazaoSocial.getText();
                String getTextCNPJ = textCNPJ.getText();
                String getTextRua = textRua.getText();
                String getTextNumero = textNumero.getText();
                String getTextComplemento = textComplemento.getText();
                String getTextBairro = textBairro.getText();
                String getTextCidade = textCidade.getText();
                String getTextUF = textUF.getText();
                String getTextCEP = textCEP.getText();
                String getTextTelefone1 = textTelefone1.getText();
                String getTextTelefone2 = textTelefone2.getText();
                String getEmail = textEmail.getText();
                String getSite = textSite.getText();
                String getTextNomeEspecialista = textNomeEspecialista.getText();
                String getTextEspecialidade = textEspecialidade.getText();
                String getTipoParceiro = (String) comboBoxTipoParceiro.getSelectedItem();

                boolean cnpjValido = false;
                String mensagemErro = "";
                String cnpjFormatado = getTextCNPJ.replaceAll("[^0-9]+", "");
                if (cnpjFormatado.length() != 14) {
                    mensagemErro = "CNPJ inválido. Por favor, digite um CNPJ válido.";
                } else {
                    try {
                        Long.parseLong(cnpjFormatado);
                        cnpjValido = true;
                    } catch (NumberFormatException ex) {
                        mensagemErro = "CNPJ inválido. Por favor, digite um CNPJ válido.";
                    }
                }

                if (cnpjValido) {
                    try {
                        // Estabelecer uma conexão com o banco de dados
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unicesumartcc",
                                "root",
                                "KMvd96ui45!");

                        // Criar uma declaração SQL preparada
                        PreparedStatement stmt = conn.prepareStatement(
                                "INSERT INTO parceiros (loginpessoa,senhapessoa,razao_social, cnpj, rua, numero, complemento, bairro, cidade, uf, cep, telefone1, telefone2, email, site, nome_especialista, especialidade, tipo_parceiro) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)");
                        stmt.setString(1, getUsuario);
                        stmt.setString(2, getSenha);
                        stmt.setString(3, getRazaoSocial);
                        stmt.setString(4, getTextCNPJ);
                        stmt.setString(5, getTextRua);
                        stmt.setString(6, getTextNumero);
                        stmt.setString(7, getTextComplemento);
                        stmt.setString(8, getTextBairro);
                        stmt.setString(9, getTextCidade);
                        stmt.setString(10, getTextUF);
                        stmt.setString(11, getTextCEP);
                        stmt.setString(12, getTextTelefone1);
                        stmt.setString(13, getTextTelefone2);
                        stmt.setString(14, getEmail);
                        stmt.setString(15, getSite);
                        stmt.setString(16, getTextNomeEspecialista);
                        stmt.setString(17, getTextEspecialidade);
                        stmt.setString(18, getTipoParceiro);

                        // Executar a declaração SQL
                        stmt.executeUpdate();

                        // Fechar a conexão com o banco de dados
                        conn.close();

                        // Exibir uma mensagem de sucesso
                        JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");

                    } catch (SQLException ex) {
                        // Verificar senhas cadastradas
                        JOptionPane.showMessageDialog(null, "Houve um erro ao tentar salvar o cadastro!!");
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, mensagemErro);
                }
            }
        });

        // Adiciona PlaceHolder
        textRazaoSocial.setText("Informe o nome da empresa completo");
        textRazaoSocial.setForeground(Color.GRAY);
        textRazaoSocial.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textRazaoSocial.getText().equals("Informe o nome da empresa completo")) {
                    textRazaoSocial.setText("");
                    textRazaoSocial.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textRazaoSocial.getText().isEmpty()) {
                    textRazaoSocial.setText("Informe o nome da empresa completo");
                    textRazaoSocial.setForeground(Color.GRAY);
                }
            }
        });

        textCNPJ.setText("CNPJ com 14 números sem caracteres especiais");
        textCNPJ.setForeground(Color.GRAY);
        textCNPJ.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textCNPJ.getText().equals("CNPJ com 14 números sem caracteres especiais")) {
                    textCNPJ.setText("");
                    textCNPJ.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textCNPJ.getText().isEmpty()) {
                    textCNPJ.setText("CNPJ com 14 números sem caracteres especiais");
                    textCNPJ.setForeground(Color.GRAY);
                }
            }
        });

        textRua.setText("Informe o nome da rua");
        textRua.setForeground(Color.GRAY);
        textRua.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textRua.getText().equals("Informe o nome da rua")) {
                    textRua.setText("");
                    textRua.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textRua.getText().isEmpty()) {
                    textRua.setText("Informe o nome da rua");
                    textRua.setForeground(Color.GRAY);
                }
            }
        });

        textNumero.setText("Número");
        textNumero.setForeground(Color.GRAY);
        textNumero.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textNumero.getText().equals("Número")) {
                    textNumero.setText("");
                    textNumero.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textNumero.getText().isEmpty()) {
                    textNumero.setText("Número");
                    textNumero.setForeground(Color.GRAY);
                }
            }
        });

        textComplemento.setText("Informe o Complemento");
        textComplemento.setForeground(Color.GRAY);
        textComplemento.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textComplemento.getText().equals("Informe o Complemento")) {
                    textComplemento.setText("");
                    textComplemento.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textComplemento.getText().isEmpty()) {
                    textComplemento.setText("Informe o Complemento");
                    textComplemento.setForeground(Color.GRAY);
                }
            }
        });

        textBairro.setText("Informe o Bairro");
        textBairro.setForeground(Color.GRAY);
        textBairro.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textBairro.getText().equals("Informe o Bairro")) {
                    textBairro.setText("");
                    textBairro.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textBairro.getText().isEmpty()) {
                    textBairro.setText("Informe o Bairro");
                    textBairro.setForeground(Color.GRAY);
                }
            }
        });

        textCidade.setText("Informe o nome da Cidade");
        textCidade.setForeground(Color.GRAY);
        textCidade.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textCidade.getText().equals("Informe o nome da Cidade")) {
                    textCidade.setText("");
                    textCidade.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textCidade.getText().isEmpty()) {
                    textCidade.setText("Informe o nome da Cidade");
                    textCidade.setForeground(Color.GRAY);
                }
            }
        });

        textUF.setText("UF");
        textUF.setForeground(Color.GRAY);
        textUF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textUF.getText().equals("UF")) {
                    textUF.setText("");
                    textUF.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textUF.getText().isEmpty()) {
                    textUF.setText("UF");
                    textUF.setForeground(Color.GRAY);
                }
            }
        });

        textCEP.setText("Ex:44700-000");
        textCEP.setForeground(Color.GRAY);
        textCEP.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textCEP.getText().equals("Ex:44700-000")) {
                    textCEP.setText("");
                    textCEP.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textCEP.getText().isEmpty()) {
                    textCEP.setText("Ex:44700-000");
                    textCEP.setForeground(Color.GRAY);
                }
            }
        });

        textTelefone1.setText("Ex:1191234-5678");
        textTelefone1.setForeground(Color.GRAY);
        textTelefone1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textTelefone1.getText().equals("Ex:1191234-5678")) {
                    textTelefone1.setText("");
                    textTelefone1.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textTelefone1.getText().isEmpty()) {
                    textTelefone1.setText("Ex:1191234-5678");
                    textTelefone1.setForeground(Color.GRAY);
                }
            }
        });

        textTelefone2.setText("Ex:1191234-5678");
        textTelefone2.setForeground(Color.GRAY);
        textTelefone2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textTelefone2.getText().equals("Ex:1191234-5678")) {
                    textTelefone2.setText("");
                    textTelefone2.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textTelefone2.getText().isEmpty()) {
                    textTelefone2.setText("Ex:1191234-5678");
                    textTelefone2.setForeground(Color.GRAY);
                }
            }
        });

        textEmail.setText("Ex:teste@teste.com");
        textEmail.setForeground(Color.GRAY);
        textEmail.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textEmail.getText().equals("Ex:teste@teste.com")) {
                    textEmail.setText("");
                    textEmail.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textEmail.getText().isEmpty()) {
                    textEmail.setText("Ex:teste@teste.com");
                    textEmail.setForeground(Color.GRAY);
                }
            }
        });

        textSite.setText("Ex:teste.com");
        textSite.setForeground(Color.GRAY);
        textSite.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textSite.getText().equals("Ex:teste.com")) {
                    textSite.setText("");
                    textSite.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textSite.getText().isEmpty()) {
                    textSite.setText("Ex:teste.com");
                    textSite.setForeground(Color.GRAY);
                }
            }
        });

        textNomeEspecialista.setText("Ex:Bruce Wayne");
        textNomeEspecialista.setForeground(Color.GRAY);
        textNomeEspecialista.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textNomeEspecialista.getText().equals("Ex:Bruce Wayne")) {
                    textNomeEspecialista.setText("");
                    textNomeEspecialista.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textNomeEspecialista.getText().isEmpty()) {
                    textNomeEspecialista.setText("Ex:Bruce Wayne");
                    textNomeEspecialista.setForeground(Color.GRAY);
                }
            }
        });

        textEspecialidade.setText("Ex:Professor");
        textEspecialidade.setForeground(Color.GRAY);
        textEspecialidade.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textEspecialidade.getText().equals("Ex:Professor")) {
                    textEspecialidade.setText("");
                    textEspecialidade.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textEspecialidade.getText().isEmpty()) {
                    textEspecialidade.setText("Ex:Professor");
                    textEspecialidade.setForeground(Color.GRAY);
                }
            }
        });

        // Define a posição e o tamanho dos itens
        titulo.setBounds(500, 10, 350, 60);
        labelRazaoSocial.setBounds(50, 100, 80, 50);
        textRazaoSocial.setBounds(128, 117, 300, 20);
        labelCNPJ.setBounds(450, 98, 350, 60);
        textCNPJ.setBounds(500, 117, 300, 20);
        labelParceiros.setBounds(810, 100, 170, 50);
        comboBoxTipoParceiro.setBounds(810, 140, 300, 20);
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
        labelCadastrar.setBounds(1000, 420, 350, 20);
        labelLogin.setBounds(1000, 450, 350, 20);
        textLogin.setBounds(1100, 450, 130, 20);
        labelPassword.setBounds(1000, 480, 350, 20);
        textPassword.setBounds(1100, 480, 130, 20);
        btnSalvar.setBounds(400, 600, 100, 20);
        btnLimpar.setBounds(600, 600, 100, 20);
        btnSair.setBounds(800, 600, 100, 20);
    }

    public static void main(String[] args) {
        cadastrarParceiros cadParceiros = new cadastrarParceiros();
        cadParceiros.setVisible(true);
    }
}
