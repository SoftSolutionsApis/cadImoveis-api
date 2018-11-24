CREATE TABLE bairro(
id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
codigo BIGINT(20),
nome VARCHAR(40),
cidade_id BIGINT(20),
FOREIGN KEY(cidade_id) REFERENCES cidade(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE logradouro(
id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
codigo BIGINT(20),
nome VARCHAR(40),
cidade_id BIGINT(20),
FOREIGN KEY(cidade_id) REFERENCES cidade(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


