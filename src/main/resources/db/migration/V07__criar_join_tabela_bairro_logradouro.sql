CREATE TABLE bairro_logradouro(
bairro_id BIGINT(20),
logradouro_id BIGINT(20),
FOREIGN KEY(bairro_id) REFERENCES bairro(id),
FOREIGN KEY(logradouro_id) REFERENCES logradouro(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


