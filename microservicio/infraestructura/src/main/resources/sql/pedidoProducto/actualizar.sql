update pedido_producto
set id_pedido = :idPedido,
id_producto = :idProducto,
cantidad = :cantidad,
precio = :precio
where id = :id