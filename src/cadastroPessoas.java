import java.awt.Font;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
        Font font2 = new Font("Arial", Font.BOLD, 15);
        JLabel titulo = new JLabel("Cadastro de Pessoas");
        JLabel cadastrarLoginSenha = new JLabel("Cadastrar Login e Senha");
        JLabel labelLoginpessoa = new JLabel("ID:");
        JTextField textLoginpessoa = new JTextField();
        JLabel labelSenha = new JLabel("Senha:");
        JTextField textSenha = new JTextField();
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
        ButtonGroup groupSexo = new ButtonGroup();
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
        JRadioButton radioOutros = new JRadioButton("Outros(a)");
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

        // Ações dos botões
        // Ação do botão Salvar
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Obter o texto digitado nas caixas de texto
                String loginPessoa = textLoginpessoa.getText();
                String senhaPessoa = textSenha.getText();
                String nome = textNome.getText();
                String profissao = textProfissao.getText();
                String rg = textRG.getText();
                String cpf = textCPF.getText();
                String escolaridade = textEscolaridade.getText();
                String dataNascimento = textDataNascimento.getText();

                // Obter o sexo selecionado
                ButtonModel selectedButton = groupSexo.getSelection();
                String sexo = "";
                if (selectedButton != null) {
                    sexo = selectedButton.getActionCommand();
                }

                try {
                    // Estabelecer uma conexão com o banco de dados
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/unicesumartcc", "root",
                            "KMvd96ui45!");

                    // Criar uma declaração SQL preparada
                    PreparedStatement stmt = conn.prepareStatement(
                            "INSERT INTO pessoa (loginpessoa, senhapessoa, nome, profissao, rg, cpf, escolaridade, data_nascimento, sexo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    stmt.setString(1, loginPessoa);
                    stmt.setString(2, senhaPessoa);
                    stmt.setString(3, nome);
                    stmt.setString(4, profissao);
                    stmt.setString(5, rg);
                    stmt.setString(6, cpf);
                    stmt.setString(7, escolaridade);
                    stmt.setString(8, dataNascimento);
                    stmt.setString(9, sexo);

                    // Executar a declaração SQL
                    stmt.executeUpdate();

                    // Fechar a conexão com o banco de dados
                    conn.close();

                    // Exibir uma mensagem de sucesso
                    JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Escolha do tamanho da fonte para o itens
        titulo.setFont(font);
        cadastrarLoginSenha.setFont(font2);

        // Adiciona os itens
        add(titulo);
        add(cadastrarLoginSenha);
        add(labelSenha);
        add(textSenha);
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

        JMenu cadastarPessoa = new JMenu("Cadastrar Pessoa");
        menuCadastro.add(cadastarPessoa);

        JMenuItem novoCadastroPessoa = new JMenuItem("Novo Cadastro");
        cadastarPessoa.add(novoCadastroPessoa);

        JMenuItem localizarPessoa = new JMenuItem("Localizar Cadastro");
        cadastarPessoa.add(localizarPessoa);

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
        textUF.setBounds(473, 217, 30, 20);
        labelEstadoCivil.setBounds(50, 250, 80, 50);
        radioCasado.setBounds(122, 250, 90, 50);
        radioSolteiro.setBounds(209, 250, 100, 50);
        radioSeparado.setBounds(305, 250, 100, 50);
        radioViuvo.setBounds(401, 250, 100, 50);
        labelEncaminhamentoEscolar.setBounds(500, 252, 190, 50);
        radioEncaminhamentoEscolarSim.setBounds(650, 252, 60, 50);
        radioEncaminhamentoEscolarNao.setBounds(710, 252, 60, 50);
        labelEncaminhamentoTrabalho.setBounds(790, 252, 190, 50);
        radioEncaminhamentoTrabalhoSim.setBounds(950, 252, 60, 50);
        radioEncaminhamentoTrabalhoNao.setBounds(1010, 252, 60, 50);
        labelEncaminhamentoMedico.setBounds(50, 300, 190, 50);
        radioEncaminhamentoMedicoSim.setBounds(200, 300, 60, 50);
        radioEncaminhamentoMedicoNao.setBounds(260, 300, 60, 50);
        labelEncaminhamentoMoradia.setBounds(340, 300, 190, 50);
        radioEncaminhamentoMoradiaSim.setBounds(525, 300, 60, 50);
        radioEncaminhamentoMoradiaNao.setBounds(582, 300, 60, 50);
        cadastrarLoginSenha.setBounds(1000, 350, 200, 30);
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