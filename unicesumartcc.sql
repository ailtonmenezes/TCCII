CREATE DATABASE unicesumartcc;

USE unicesumartcc;

CREATE TABLE
    parceiros (
        id INT(11) NOT NULL AUTO_INCREMENT,
        loginpessoa VARCHAR(20) UNIQUE,
        senhapessoa VARCHAR(30),
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
        rg VARCHAR(10),
        cpf VARCHAR(11) UNIQUE,
        profissao VARCHAR(30),
        escolaridade VARCHAR(30),
        data_nascimento DATE,
        sexo VARCHAR(1),
        naturalidade VARCHAR(30),
        uf VARCHAR(2),
        estado_civil VARCHAR(10),
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
    parceiros (
        loginpessoa,
        senhapessoa,
        razao_social,
        cnpj,
        tipo_parceiro,
        rua,
        numero,
        complemento,
        bairro,
        cidade,
        uf,
        cep,
        telefone1,
        telefone2,
        email,
        site,
        nome_especialista,
        especialidade
    )
VALUES (
        'unicesumarEad',
        'unicesumar1234',
        'Universidade de Maringá',
        '79265617000199',
        'Instituição de Educação',
        'Av. Guedner',
        '1610',
        'Sem Complemento',
        'Jardim Aclimacao',
        'Maringá',
        'PR',
        '87050900',
        '4430276360',
        '4430276222',
        'atendimento@unicesumar.edu.br',
        'https://www.unicesumar.edu.br/',
        'Janaina Freitas',
        'Professora Mediadora'
    );

INSERT INTO
    parceiros (
        loginpessoa,
        senhapessoa,
        razao_social,
        cnpj,
        tipo_parceiro,
        rua,
        numero,
        complemento,
        bairro,
        cidade,
        uf,
        cep,
        telefone1,
        telefone2,
        email,
        site,
        nome_especialista,
        especialidade
    )
VALUES (
        'unicesumar',
        'unicesumar123',
        'Universidade de Maringá',
        '79265617000199',
        'Instituição de Educação',
        'Av. Guedner',
        '1610',
        'Sem Complemento',
        'Jardim Aclimacao',
        'Maringá',
        'PR',
        '87050900',
        '4430276360',
        '4430276222',
        'atendimento@unicesumar.edu.br',
        'https://www.unicesumar.edu.br/',
        'Rafael Alves Florindo',
        'Professor de Tecnologia'
    );

INSERT INTO
    pessoa (
        nome,
        rg,
        cpf,
        profissao,
        escolaridade,
        data_nascimento,
        sexo,
        naturalidade,
        uf,
        estado_civil,
        escolar,
        medico,
        trabalho,
        moradia,
        observacoes
    )
VALUES (
        'Bruce Wayne',
        '12345678',
        '12345678911',
        'Detetive',
        'Ensino Médio',
        '1992-02-10',
        'M',
        'Suzano',
        'SP',
        'Solteiro',
        'Sim',
        'Não',
        'Não',
        'Não',
        'Detetive Noturno'
    );

INSERT INTO
    pessoa (
        nome,
        rg,
        cpf,
        profissao,
        escolaridade,
        data_nascimento,
        sexo,
        naturalidade,
        uf,
        estado_civil,
        escolar,
        medico,
        trabalho,
        moradia,
        observacoes
    )
VALUES (
        'Clark Kent',
        '12345678',
        '12345678912',
        'Detetive',
        'Ensino Médio',
        '1990-05-09',
        'M',
        'Jabobina',
        'BA',
        'Solteiro',
        'Sim',
        'Não',
        'Não',
        'Não',
        'Jornalista'
    );

SELECT * FROM parceiros 