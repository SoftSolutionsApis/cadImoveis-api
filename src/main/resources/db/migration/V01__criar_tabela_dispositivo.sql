CREATE TABLE dispositivo(
id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
imei VARCHAR(40),
numero VARCHAR(20),
ip VARCHAR(40),
disponivel BOOLEAN
)ENGINE=InnoDB DEFAULT CHARSET=utf8;