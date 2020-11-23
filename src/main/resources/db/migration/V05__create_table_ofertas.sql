CREATE TABLE ofertas (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  valor decimal(19,2) DEFAULT NULL,
  data_da_entrega date DEFAULT NULL,
  comentario varchar(2000) NOT NULL,
  pedido_id bigint(20) not null,
  PRIMARY KEY (id),
  KEY fk_oferta_pedido (pedido_id),
  constraint fk_oferta_pedido foreign key (pedido_id) references pedidos (id) 
)
