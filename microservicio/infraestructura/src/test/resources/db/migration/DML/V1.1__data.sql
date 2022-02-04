insert into usuario(id, nombre,clave,fecha_creacion) values(1,'test','1234',now());
insert into festivos(id, fecha) values(1,'2022-01-10');
insert into producto(id, nombre,cantidad,precio) values(1,'Arroz', 20, 50000);
insert into pedido(id, fecha, domicilio) values(1,'2022-01-24 08:25:00', 10000);
insert into pedido_producto(id, id_pedido, id_producto, cantidad, precio) values(1, 1, 1, 10, 50000);