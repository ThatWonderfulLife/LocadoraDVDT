DROP TABLE IF EXISTS tb_historico;
DROP TABLE IF EXISTS tb_alugados;
DROP TABLE IF EXISTS tb_usuario;
DROP TABLE IF EXISTS tb_pessoa;
DROP TABLE IF EXISTS tb_filme;

CREATE TABLE IF NOT EXISTS tb_pessoa(
idPessoa             SERIAL      PRIMARY KEY,
nomePessoa           VARCHAR(60) NOT NULL UNIQUE,
cpfPessoa            VARCHAR(11) UNIQUE,
telefonePessoa       VARCHAR(14),
emailPessoa          VARCHAR(60),
enderecoPessoa       VARCHAR(50),
dataDeNascPessoa     VARCHAR(10),
sexoPessoa           VARCHAR(9)
);
CREATE TABLE IF NOT EXISTS tb_usuario(
nomeUsuario          VARCHAR(60) UNIQUE REFERENCES tb_pessoa(nomePessoa) ON UPDATE CASCADE ON DELETE CASCADE,
senhaUsuario         VARCHAR(16),
salarioUsuario       FLOAT
);

CREATE TABLE IF NOT EXISTS tb_filme(
idFilme              SERIAL      PRIMARY KEY,
nomeFilme            VARCHAR(40) NOT NULL,
faixaEtariaFilme     VARCHAR(6),
lancamentoFilme      INTEGER,
diretorFilme         VARCHAR(60),
generoFilme          VARCHAR(25) NOT NULL,
disponivelFilme      INTEGER,
sinopseFilme         VARCHAR(600)
);

CREATE TABLE IF NOT EXISTS tb_alugados(
idAlugados           SERIAL      PRIMARY KEY,
clienteAlugados      VARCHAR(60) REFERENCES tb_pessoa(nomePessoa) ON UPDATE CASCADE,
filmeAlugados        INTEGER     REFERENCES tb_filme(idFilme) ON UPDATE CASCADE,
usuarioAlugados      varchar(60) REFERENCES tb_usuario(nomeUsuario) ON UPDATE CASCADE,
retiradaAlugados     VARCHAR(10) NOT NULL,
entregaAlugados      VARCHAR(10) NOT NULL,
precoAlugados        FLOAT,
ativoAlugados        BOOLEAN NOT NULL
);

INSERT INTO tb_pessoa(nomePessoa) VALUES ('root');
    SELECT 'root'
        WHERE NOT EXISTS (SELECT nomeUsuario FROM tb_usuario WHERE nomeUsuario = 'root');
INSERT INTO tb_usuario(nomeUsuario)
    SELECT 'root'
        WHERE NOT EXISTS (SELECT senhaUsuario FROM tb_usuario WHERE nomeUsuario = 'root');

