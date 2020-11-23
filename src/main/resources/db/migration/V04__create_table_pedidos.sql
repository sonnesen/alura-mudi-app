CREATE TABLE pedidos (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  data_da_entrega date DEFAULT NULL,
  descricao varchar(2000) NOT NULL,
  nome_produto varchar(255) NOT NULL,
  status varchar(255) NOT NULL,
  url_imagem varchar(2000) NOT NULL,
  url_produto varchar(2000) NOT NULL,
  valor_negociado decimal(19,2) DEFAULT NULL,
  usuario varchar(255) not null,
  PRIMARY KEY (id),
  KEY fk_pedido_usuario (usuario),
  constraint fk_pedido_usuario foreign key (usuario) references users (username) 
)
