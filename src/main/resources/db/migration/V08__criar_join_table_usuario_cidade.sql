CREATE TABLE usuario_cidade(
usuario_id BIGINT(20),
cidade_id BIGINT(20),
FOREIGN KEY(usuario_id) REFERENCES usuario(id),
FOREIGN KEY(cidade_id) REFERENCES cidade(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


