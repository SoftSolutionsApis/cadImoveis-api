CREATE TABLE estado (
id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(40) NOT NULL,
uf VARCHAR(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO estado(nome, uf)values ('PERNAMBUCO', 'PE');
INSERT INTO estado(nome, uf)values ('ALAGOAS', 'AL');
INSERT INTO estado(nome, uf)values ('PARAIBA', 'PB');
