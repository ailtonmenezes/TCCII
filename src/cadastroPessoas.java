import java.awt.Font;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class cadastroPessoas extends JFrame {
    public cadastroPessoas() {
        super("Cadastro de Pessoas");
        ImageIcon sisbrasImageIcon = new ImageIcon("src/img/SISBRASLogo2.png");
        setIconImage(sisbrasImageIcon.getImage());

        setSize(800, 600);
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(null);

        // Cria os itens
        Font font = new Font("Arial", Font.BOLD, 30);
        JLabel titulo = new JLabel("Cadastro de Pessoas");
        JLabel labelNome = new JLabel("Nome:");
        JTextField textNome = new JTextField();
        JLabel labelProfissao = new JLabel("Profissão:");
        JTextField textProfissao = new JTextField();
        JLabel labelEscolaridade = new JLabel("Escolaridade:");
        JTextField textEscolaridade = new JTextField();
        JLabel labelRG = new JLabel("RG:");
        JTextField textRG = new JTextField();
        JLabel labelCPF = new JLabel("CPF:");
        JTextField textCPF = new JTextField();
        JLabel labelDataNascimento = new JLabel("Data de Nascimento:");
        JTextField textDataNascimento = new JTextField();
        JLabel labelSexo = new JLabel("Sexo:");
        JRadioButton radioMasculino = new JRadioButton("M");
        JRadioButton radioFeminino = new JRadioButton("F");
        JRadioButton radioOutro = new JRadioButton("Outro");
        JLabel labelNaturalidade = new JLabel("Naturalidade:");
        JTextField textNaturalidade = new JTextField();
        JLabel labelUF = new JLabel("UF:");
        JTextField textUF = new JTextField();
        JLabel labelEstadoCivil = new JLabel("Estado Civil:");
        JRadioButton radioCasado = new JRadioButton("Casado(a)");
        JRadioButton radioSolteiro = new JRadioButton("Solteiro(a)");
        JRadioButton radioSeparado = new JRadioButton("Separado(a)");
        JRadioButton radioViuvo = new JRadioButton("Viúvo(a)");
        JRadioButton radioOutros = new JRadioButton("Outro(a)");
        JLabel labelEncaminhamentoEscolar = new JLabel("Encaminhamento Escolar:");
        JRadioButton radioEncaminhamentoEscolarSim = new JRadioButton("Sim");
        JRadioButton radioEncaminhamentoEscolarNao = new JRadioButton("Não");
        JLabel labelEncaminhamentoTrabalho = new JLabel("Encaminhamento Trabalho:");
        JRadioButton radioEncaminhamentoTrabalhoSim = new JRadioButton("Sim");
        JRadioButton radioEncaminhamentoTrabalhoNao = new JRadioButton("Não");
        JLabel labelEncaminhamentoMedico = new JLabel("Encaminhamento Medico:");
        JRadioButton radioEncaminhamentoMedicoSim = new JRadioButton("Sim");
        JRadioButton radioEncaminhamentoMedicoNao = new JRadioButton("Não");
        JLabel labelEncaminhamentoMoradia = new JLabel("Encaminhamento para Moradia:");
        JRadioButton radioEncaminhamentoMoradiaSim = new JRadioButton("Sim");
        JRadioButton radioEncaminhamentoMoradiaNao = new JRadioButton("Não");
        JLabel informacoesFamiliares = new JLabel("Informações sobre Familiares:");
        JTextArea textInformacoesFamiliares = new JTextArea();
        JButton btnSalvar = new JButton("Salvar");
        JButton btnLimpar = new JButton("Limpar");
        JButton btnSair = new JButton("Sair");
        JLabel consultor = new JLabel("Consultor:");
        JLabel idConsultor = new JLabel("nome");

        // Cria os grupos
        ButtonGroup groupSexo = new ButtonGroup();
        groupSexo.add(radioMasculino);
        groupSexo.add(radioFeminino);
        groupSexo.add(radioOutro);

        ButtonGroup groupEstadoCivil = new ButtonGroup();
        groupEstadoCivil.add(radioCasado);
        groupEstadoCivil.add(radioSolteiro);
        groupEstadoCivil.add(radioSeparado);
        groupEstadoCivil.add(radioViuvo);
        groupEstadoCivil.add(radioOutros);

        ButtonGroup groupEncaminhmentoEscolar = new ButtonGroup();
        groupEncaminhmentoEscolar.add(radioEncaminhamentoEscolarSim);
        groupEncaminhmentoEscolar.add(radioEncaminhamentoEscolarNao);

        ButtonGroup groupEncaminhmentoTrabalho = new ButtonGroup();
        groupEncaminhmentoTrabalho.add(radioEncaminhamentoTrabalhoSim);
        groupEncaminhmentoTrabalho.add(radioEncaminhamentoTrabalhoNao);

        ButtonGroup groupEncaminhmentoMedico = new ButtonGroup();
        groupEncaminhmentoMedico.add(radioEncaminhamentoMedicoSim);
        groupEncaminhmentoMedico.add(radioEncaminhamentoMedicoNao);

        ButtonGroup groupEncaminhmentoMoradia = new ButtonGroup();
        groupEncaminhmentoMoradia.add(radioEncaminhamentoMoradiaSim);
        groupEncaminhmentoMoradia.add(radioEncaminhamentoMoradiaNao);

        // Ações dos botões

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
                textNome.setText("");
                textProfissao.setText("");
                textRG.setText("");
                textCPF.setText("");
                textEscolaridade.setText("");
                textDataNascimento.setText("");
                textNaturalidade.setText("");
                textUF.setText("");
            }
        });

        // Ação do botão Salvar
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obter o texto digitado nas caixas de texto
                String nome = textNome.getText();
                String profissao = textProfissao.getText();
                String rg = textRG.getText();
                String cpf = textCPF.getText();
                String escolaridade = textEscolaridade.getText();
                String dataNascimento = textDataNascimento.getText();
                radioMasculino.setActionCommand("M");
                radioFeminino.setActionCommand("F");
                radioOutro.setActionCommand("Outro");
                radioCasado.setActionCommand("Casado");
                radioSolteiro.setActionCommand("Solteiro");
                radioSeparado.setActionCommand("Separado");
                radioViuvo.setActionCommand("Viúvo");
                radioOutros.setActionCommand("Outro");
                radioEncaminhamentoEscolarSim.setActionCommand("Sim");
                radioEncaminhamentoEscolarNao.setActionCommand("Não");
                radioEncaminhamentoMedicoSim.setActionCommand("Sim");
                radioEncaminhamentoMedicoNao.setActionCommand("Não");
                radioEncaminhamentoTrabalhoSim.setActionCommand("Sim");
                radioEncaminhamentoTrabalhoNao.setActionCommand("Não");
                radioEncaminhamentoMoradiaSim.setActionCommand("Sim");
                radioEncaminhamentoMoradiaNao.setActionCommand("Não");
                String naturalidade = textNaturalidade.getText();
                String uf = textUF.getText();

                // Valida CPF
                boolean cpfValido = false;
                String mensagemErro = "";
                String cpfFormatado = cpf.replaceAll("[^0-9]+", "");
                if (cpfFormatado.length() != 11) {
                    mensagemErro = "CPF inválido. Por favor, digite um CPF válido.";
                } else {
                    try {
                        Long.parseLong(cpfFormatado);
                        cpfValido = true;
                    } catch (NumberFormatException ex) {
                        mensagemErro = "CPF inválido. Por favor, digite um CPF válido.";
                    }
                }

                if (cpfValido) {
                    // Obter o sexo selecionado
                    ButtonModel selectedButtonSexo = groupSexo.getSelection();
                    String sexo = "";
                    if (selectedButtonSexo != null) {
                        sexo = selectedButtonSexo.getActionCommand();
                    }

                    ButtonModel selectdButtonEstCivil = groupEstadoCivil.getSelection();
                    String estado_civil = "";
                    if (selectdButtonEstCivil != null) {
                        estado_civil = selectdButtonEstCivil.getActionCommand();
                    }

                    ButtonModel selectdButtonEscolar = groupEncaminhmentoEscolar.getSelection();
                    String escolar = "";
                    if (selectdButtonEscolar != null) {
                        escolar = selectdButtonEscolar.getActionCommand();
                    }

                    ButtonModel selectedButtonMedico = groupEncaminhmentoTrabalho.getSelection();
                    String medico = "";
                    if (selectedButtonMedico != null) {
                        medico = selectedButtonMedico.getActionCommand();
                    }

                    ButtonModel selectedButtonTrabalho = groupEncaminhmentoTrabalho.getSelection();
                    String trabalho = "";
                    if (selectedButtonTrabalho != null) {
                        trabalho = selectedButtonTrabalho.getActionCommand();
                    }

                    ButtonModel selectedButtonMoradia = groupEncaminhmentoMoradia.getSelection();
                    String moradia = "";
                    if (selectedButtonMoradia != null) {
                        moradia = selectedButtonMoradia.getActionCommand();
                    }
                    String observacoes = textInformacoesFamiliares.getText();

                    try {
                        // Estabelecer uma conexão com o banco de dados
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unicesumartcc",
                                "root",
                                "KMvd96ui45!");

                        // Criar uma declaração SQL preparada
                        PreparedStatement stmt = conn.prepareStatement(
                                "INSERT INTO pessoa (nome, profissao, rg, cpf, escolaridade, data_nascimento, sexo, naturalidade, uf, estado_civil, escolar, medico, trabalho, moradia, observacoes) "
                                        +
                                        "VALUES (?, ?, ?, ?, ?, DATE_FORMAT(STR_TO_DATE(?, '%d/%m/%Y'), '%Y-%m-%d'), ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                        stmt.setString(1, nome);
                        stmt.setString(2, profissao);
                        stmt.setString(3, rg);
                        stmt.setString(4, cpf);
                        stmt.setString(5, escolaridade);
                        stmt.setString(6, dataNascimento);
                        stmt.setString(7, sexo);
                        stmt.setString(8, naturalidade);
                        stmt.setString(9, uf);
                        stmt.setString(10, estado_civil);
                        stmt.setString(11, escolar);
                        stmt.setString(12, medico);
                        stmt.setString(13, trabalho);
                        stmt.setString(14, moradia);
                        stmt.setString(15, observacoes);

                        // Executar a declaração SQL
                        stmt.executeUpdate();

                        // Fechar a conexão com o banco de dados
                        conn.close();

                        // Exibir uma mensagem de sucesso
                        JOptionPane.showMessageDialog(null, "Cadastro Efetuado com sucesso!");

                    }

                    catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Houve um erro ao tentar salvar o cadastro!!");
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, mensagemErro);
                }
            }
        });

        // Adiciona PlaceHolder
        textNome.setText("Informe o nome completo");
        textNome.setForeground(Color.GRAY);
        textNome.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textNome.getText().equals("Informe o nome completo")) {
                    textNome.setText("");
                    textNome.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textNome.getText().isEmpty()) {
                    textNome.setText("Informe o nome completo");
                    textNome.setForeground(Color.GRAY);
                }
            }
        });

        // Setting the text of the textCPF to "Ex: 12345678911"
        textCPF.setText("Ex: 12345678911");
        textCPF.setForeground(Color.GRAY);
        textCPF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textCPF.getText().equals("Ex: 12345678911")) {
                    textCPF.setText("");
                    textCPF.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textCPF.getText().isEmpty()) {
                    textCPF.setText("Ex: 12345678911");
                    textCPF.setForeground(Color.GRAY);
                }
            }
        });

        textRG.setText("Ex: 12345678911");
        textRG.setForeground(Color.GRAY);
        textRG.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textRG.getText().equals("Ex: 12345678911")) {
                    textRG.setText("");
                    textRG.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textRG.getText().isEmpty()) {
                    textRG.setText("Ex: 12345678911");
                    textRG.setForeground(Color.GRAY);
                }
            }
        });

        textDataNascimento.setText("Ex:dd/mm/aaaa");
        textDataNascimento.setForeground(Color.GRAY);
        textDataNascimento.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textDataNascimento.getText().equals("Ex:dd/mm/aaaa")) {
                    textDataNascimento.setText("");
                    textDataNascimento.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textDataNascimento.getText().isEmpty()) {
                    textDataNascimento.setText("Ex:dd/mm/aaaa");
                    textDataNascimento.setForeground(Color.GRAY);
                }
            }
        });

        textProfissao.setText("Informe a Profissão");
        textProfissao.setForeground(Color.GRAY);
        textProfissao.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textProfissao.getText().equals("Informe a Profissão")) {
                    textProfissao.setText("");
                    textProfissao.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textProfissao.getText().isEmpty()) {
                    textProfissao.setText("Informe a Profissão");
                    textProfissao.setForeground(Color.GRAY);
                }
            }
        });

        textEscolaridade.setText("Informe a Escolaridade");
        textEscolaridade.setForeground(Color.GRAY);
        textEscolaridade.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textEscolaridade.getText().equals("Informe a Escolaridade")) {
                    textEscolaridade.setText("");
                    textEscolaridade.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textEscolaridade.getText().isEmpty()) {
                    textEscolaridade.setText("Informe a Escolaridade");
                    textEscolaridade.setForeground(Color.GRAY);
                }
            }
        });

        textNaturalidade.setText("Informe a Naturalidade");
        textNaturalidade.setForeground(Color.GRAY);
        textNaturalidade.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textNaturalidade.getText().equals("Informe a Naturalidade")) {
                    textNaturalidade.setText("");
                    textNaturalidade.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textNaturalidade.getText().isEmpty()) {
                    textNaturalidade.setText("Informe a Naturalide");
                    textNaturalidade.setForeground(Color.GRAY);
                }
            }
        });

        textUF.setText("Ex:Ba");
        textUF.setForeground(Color.GRAY);
        textUF.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textUF.getText().equals("Ex:Ba")) {
                    textUF.setText("");
                    textUF.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textUF.getText().isEmpty()) {
                    textUF.setText("Ex:Ba");
                    textUF.setForeground(Color.GRAY);
                }
            }
        });

        // Escolha do tamanho da fonte para o itens
        titulo.setFont(font);

        // Adiciona os itens
        add(titulo);
        add(labelNome);
        add(textNome);
        add(labelProfissao);
        add(textProfissao);
        add(labelEscolaridade);
        add(textEscolaridade);
        add(labelRG);
        add(textRG);
        add(labelCPF);
        add(textCPF);
        add(labelDataNascimento);
        add(textDataNascimento);
        add(labelSexo);
        add(radioMasculino);
        add(radioFeminino);
        add(radioOutro);
        add(labelNaturalidade);
        add(textNaturalidade);
        add(labelUF);
        add(textUF);
        add(labelEstadoCivil);
        add(radioCasado);
        add(radioSolteiro);
        add(radioSeparado);
        add(radioViuvo);
        add(radioOutros);
        add(labelEncaminhamentoEscolar);
        add(radioEncaminhamentoEscolarSim);
        add(radioEncaminhamentoEscolarNao);
        add(labelEncaminhamentoTrabalho);
        add(radioEncaminhamentoTrabalhoSim);
        add(radioEncaminhamentoTrabalhoNao);
        add(labelEncaminhamentoMedico);
        add(radioEncaminhamentoMedicoSim);
        add(radioEncaminhamentoMedicoNao);
        add(labelEncaminhamentoMoradia);
        add(radioEncaminhamentoMoradiaSim);
        add(radioEncaminhamentoMoradiaNao);
        add(informacoesFamiliares);
        add(textInformacoesFamiliares);
        add(btnSalvar);
        add(btnLimpar);
        add(btnSair);
        add(consultor);
        add(idConsultor);

        // Criar Menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuCadastro = new JMenu("Cadastros");
        menuBar.add(menuCadastro);

        JMenu cadastro = new JMenu("Cadastrar Pessoa");
        menuCadastro.add(cadastro);

        JMenuItem localizarPessoa = new JMenuItem("Localizar Cadastro");
        cadastro.add(localizarPessoa);

        JMenu cadastrarSaude = new JMenu("Cadastrar Instituição de Saúde");
        menuCadastro.add(cadastrarSaude);

        JMenuItem novoCadastroSaude = new JMenuItem("Novo Cadastro");
        cadastrarSaude.add(novoCadastroSaude);

        JMenuItem localizarSaude = new JMenuItem("Localizar Cadastro");
        cadastrarSaude.add(localizarSaude);

        JMenu cadastrarEnsino = new JMenu("Cadastrar Instituição de Ensino");
        menuCadastro.add(cadastrarEnsino);

        JMenuItem novoCadastroEnsino = new JMenuItem("Novo Cadastro");
        cadastrarEnsino.add(novoCadastroEnsino);

        JMenuItem localizarEnsino = new JMenuItem("Localizar Cadastro");
        cadastrarEnsino.add(localizarEnsino);

        JMenu cadastrarHabitacao = new JMenu("Cadastro para Habitação");
        menuCadastro.add(cadastrarHabitacao);

        JMenuItem novoCadastroHabitacao = new JMenuItem("Novo Cadastro");
        cadastrarHabitacao.add(novoCadastroHabitacao);

        JMenuItem localizarHabitacao = new JMenuItem("Localizar Cadastro");
        cadastrarHabitacao.add(localizarHabitacao);

        JMenu cadastrarEmprego = new JMenu("Cadastro para Emprego");
        menuCadastro.add(cadastrarEmprego);

        JMenuItem novoCadastroEmprego = new JMenuItem("Novo Cadastro");
        cadastrarEmprego.add(novoCadastroEmprego);

        JMenuItem localizarEmprego = new JMenuItem("Localizar Cadastro");
        cadastrarEmprego.add(localizarEmprego);

        JMenu cadastrarConsultor = new JMenu("Cadastro de Consultores");
        menuCadastro.add(cadastrarConsultor);

        JMenuItem novoCadastroConsultor = new JMenuItem("Novo Cadastro");
        cadastrarConsultor.add(novoCadastroConsultor);

        JMenuItem localizarConsultor = new JMenuItem("Localizar Cadastro");
        cadastrarConsultor.add(localizarConsultor);

        JMenu menuSobre = new JMenu("Sobre");

        JMenuItem sobreMenuItem = new JMenuItem("SisBras");

        menuSobre.add(sobreMenuItem);

        menuBar.add(menuSobre);

        // Ações do menu

        // Ação do Menu Localizar
        localizarPessoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                localizaCadastroPessoa localizaCadPessoa = new localizaCadastroPessoa();
                localizaCadPessoa.setVisible(true);
            }
        });
        sobreMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "SisBras\nVersão Beta/Protótipo\nDesenvolvido por Ailton Menezes\nCopyright ©");
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

        // Define a posição e o tamanho dos itens
        titulo.setBounds(500, 10, 350, 60);
        labelNome.setBounds(50, 100, 80, 50);
        textNome.setBounds(90, 117, 300, 20);
        labelProfissao.setBounds(400, 100, 80, 50);
        textProfissao.setBounds(462, 117, 300, 20);
        labelEscolaridade.setBounds(770, 100, 80, 50);
        textEscolaridade.setBounds(850, 117, 300, 20);
        labelRG.setBounds(50, 150, 80, 50);
        textRG.setBounds(73, 167, 120, 20);
        labelCPF.setBounds(200, 150, 80, 50);
        textCPF.setBounds(228, 167, 120, 20);
        labelDataNascimento.setBounds(368, 150, 200, 50);
        textDataNascimento.setBounds(490, 167, 90, 20);
        labelSexo.setBounds(600, 152, 80, 50);
        radioMasculino.setBounds(640, 152, 40, 50);
        radioFeminino.setBounds(690, 152, 40, 50);
        radioOutro.setBounds(735, 152, 80, 50);
        labelNaturalidade.setBounds(50, 200, 80, 50);
        textNaturalidade.setBounds(130, 217, 300, 20);
        labelUF.setBounds(450, 202, 80, 50);
        textUF.setBounds(473, 217, 35, 20);
        labelEstadoCivil.setBounds(50, 250, 80, 50);
        radioCasado.setBounds(122, 250, 90, 50);
        radioSolteiro.setBounds(209, 250, 100, 50);
        radioSeparado.setBounds(305, 250, 100, 50);
        radioViuvo.setBounds(401, 250, 90, 50);
        radioOutros.setBounds(487, 250, 80, 50);
        labelEncaminhamentoEscolar.setBounds(580, 252, 190, 50);
        radioEncaminhamentoEscolarSim.setBounds(730, 252, 60, 50);
        radioEncaminhamentoEscolarNao.setBounds(790, 252, 60, 50);
        labelEncaminhamentoTrabalho.setBounds(870, 252, 190, 50);
        radioEncaminhamentoTrabalhoSim.setBounds(1025, 252, 60, 50);
        radioEncaminhamentoTrabalhoNao.setBounds(1082, 252, 60, 50);
        labelEncaminhamentoMedico.setBounds(50, 300, 190, 50);
        radioEncaminhamentoMedicoSim.setBounds(200, 300, 60, 50);
        radioEncaminhamentoMedicoNao.setBounds(260, 300, 60, 50);
        labelEncaminhamentoMoradia.setBounds(340, 300, 190, 50);
        radioEncaminhamentoMoradiaSim.setBounds(525, 300, 60, 50);
        radioEncaminhamentoMoradiaNao.setBounds(582, 300, 60, 50);
        informacoesFamiliares.setBounds(50, 350, 350, 60);
        textInformacoesFamiliares.setBounds(50, 400, 350, 100);
        btnSalvar.setBounds(450, 600, 80, 30);
        btnLimpar.setBounds(600, 600, 80, 30);
        btnSair.setBounds(750, 600, 80, 30);
        consultor.setBounds(50, 650, 80, 30);
        idConsultor.setBounds(115, 650, 80, 30);
    }

    public static void main(String[] args) {
        cadastroPessoas cadastro = new cadastroPessoas();
        cadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}