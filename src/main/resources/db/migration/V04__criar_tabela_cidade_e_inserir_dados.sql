CREATE TABLE cidade (
id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(100) NOT NULL,
uf_id BIGINT(20) NOT NULL,
FOREIGN KEY(uf_id) REFERENCES estado(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO cidade(nome, uf_id) values ('LAGOA DE ITAENGA', 1);
INSERT INTO cidade(nome, uf_id) values ('LAGOA DO CARRO', 1);
INSERT INTO cidade(nome, uf_id) values ('CARPINA', 1);
INSERT INTO cidade(nome, uf_id) values ('RECIFE', 1);
INSERT INTO cidade(nome, uf_id) values ('BOM JARDIM', 1);
INSERT INTO cidade(nome, uf_id) values ('LIMOEIRO', 1);
INSERT INTO cidade(nome, uf_id) values ('FEIRA NOVA', 1);
INSERT INTO cidade(nome, uf_id) values ('GLÓRIA DO GOITÁ', 1);

INSERT INTO cidade(nome, uf_id) values ('JOÃO PESSOA', 2);

