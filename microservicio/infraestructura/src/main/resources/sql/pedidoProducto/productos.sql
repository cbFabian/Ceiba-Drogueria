select id, id_pedido, id_producto, cantidad, precio
from pedido_producto
where id_pedido = :id