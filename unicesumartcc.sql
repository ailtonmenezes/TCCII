CREATE DATABASE unicesumartcc;

USE unicesumartcc;

CREATE TABLE
    parceiros (
        id INT(11) NOT NULL AUTO_INCREMENT,
        razao_social VARCHAR(255) NOT NULL,
        cnpj VARCHAR(14) NOT NULL,
        tipo_parceiro VARCHAR(50) NOT NULL,
        rua VARCHAR(255) NOT NULL,
        numero INT(11) NOT NULL,
        complemento VARCHAR(255),
        bairro VARCHAR(100) NOT NULL,
        cidade VARCHAR(100) NOT NULL,
        uf VARCHAR(2) NOT NULL,
        cep VARCHAR(8) NOT NULL,
        telefone1 VARCHAR(20) NOT NULL,
        telefone2 VARCHAR(20),
        email VARCHAR(255) NOT NULL,
        site VARCHAR(255),
        nome_especialista VARCHAR(255),
        especialidade VARCHAR(255),
        PRIMARY KEY (id)
    );

CREATE TABLE
    pessoa (
        id_pessoa INT NOT NULL AUTO_INCREMENT,
        nome VARCHAR(30) NOT NULL,
        profissao VARCHAR(30),
        rg VARCHAR(10),
        cpf VARCHAR(11) UNIQUE,
        escolaridade VARCHAR(30),
        data_nascimento DATE,
        sexo VARCHAR(1),
        naturalidade VARCHAR(30),
        uf VARCHAR(2),
        estado_civil VARCHAR(1),
        escolar VARCHAR(255),
        medico VARCHAR(255),
        trabalho VARCHAR(255),
        moradia VARCHAR(255),
        observacoes TEXT,
        PRIMARY KEY (id_pessoa),
        id_parceiro INT,
        FOREIGN KEY (id_parceiro) REFERENCES parceiros(id)
    );

INSERT INTO
    endereco (
        rua,
        numero,
        complemento,
        bairro,
        cidade,
        estado,
        cep
    )
VALUES (
        "Rua Terror",
        "50",
        "Próximo ao Cinema",
        "Jardim Sinistro",
        "Gothan",
        "SP",
        "08501523"
    ), (
        "Rua Esperança",
        "255",
        "Próximo ao Planeta Diário",
        "Jardim da Paz",
        "SmallVille",
        "BA",
        "44800228"
    ), (
        "Rua Mangabeiras",
        "45",
        "13º Andar",
        "Vila Urupês",
        "Jacobina",
        "BA",
        "44700000"
    ), (
        "Rua Castro Alves",
        "88",
        "Próximo a Praça",
        "Poetas",
        "Jacobina",
        "BA",
        "44700000"
    ), (
        "Rua Monsenhor Nuno",
        "565",
        "Loja",
        "Centro",
        "Suzano",
        "SP",
        "08674090"
    ), (
        "Rua Lanterna Verde",
        "123",
        "Não tem",
        "Bananeira",
        "Jacobina",
        "BA",
        "44700000"
    ), (
        "Rua Tony Stark",
        "15",
        "Não tem",
        "Vingadores",
        "Jacobina",
        "BA",
        "44700000"
    );

;

INSERT INTO
    inst_saude(
        loginpessoa,
        senhapessoa,
        razao_social,
        telefone1,
        telefone2,
        email,
        pagina,
        id_endereco
    )
values (
        "recuperacao",
        "recuperacao",
        "Clinica de Recuperação",
        "7436218638",
        "743621545",
        "clinicarecuperacao@clinica.org",
        "clinica@vida.com",
        3
    );

INSERT INTO
    inst_ensino(
        loginpessoa,
        senhapessoa,
        razao_social,
        cnpj,
        telefone1,
        telefone2,
        email,
        pagina,
        id_endereco
    )
values (
        "calves",
        "calves",
        "Escola Castro Alves",
        "546585258001",
        "7436211599",
        "7436211598",
        "castroalves@edu.com.br",
        "escolacastroalves.com.br",
        3
    ), (
        "unicesumar",
        "unicesumar",
        "Unicesumar Suzano",
        "792656170001",
        "1128913788",
        "1128913788",
        "tcc@unicesumar.edu.br",
        "unicesumar.edu.br",
        4
    );

INSERT INTO
    consultor(
        loginpessoa,
        senhapessoa,
        nome,
        rg,
        cpf,
        profissao,
        escolaridade,
        data_nascimento,
        sexo,
        naturalidade,
        estado_civil,
        id_endereco
    )
VALUES (
        "stevieroger",
        "camerica",
        "Stevie Roger",
        "888555",
        "98765432118",
        "Médico",
        "Ensino Superior Completo",
        "1990-05-18",
        "M",
        "Jacobina",
        "C",
        5
    );

INSERT INTO
    empresa(
        loginpessoa,
        senhapessoa,
        razao_social,
        cnpj,
        telefone1,
        telefone2,
        email,
        pagina,
        id_endereco
    )
VALUES (
        "modernosuper",
        "mercado",
        "Supermercado Moderno",
        "5286541590001",
        "7436211515",
        "7436218998",
        "moderno@gmail.com",
        "modernosupermercado.com.br",
        6
    );

INSERT INTO
    pessoa (
        loginpessoa,
        senhapessoa,
        nome,
        rg,
        cpf,
        escolaridade,
        data_nascimento,
        sexo,
        naturalidade,
        estado_civil,
        id_endereco
    )
VALUES (
        "brucewayne",
        "batman",
        "Bruce Batman Wayne",
        "1122234",
        "11122233345",
        "Ensino Médio Incompleto",
        "1989-11-15",
        "M",
        "Jacobina-Ba",
        "S",
        1
    ), (
        "clarkkent",
        "superman",
        "Clark Superman Kent",
        "1122235",
        "11122233346",
        "Ensino Médio",
        "1980-12-19",
        "M",
        "Suzano-SP",
        "V",
        2
    );