package com.ceiba.pedidoProducto.puerto.repositorio;

import com.ceiba.pedidoProducto.modelo.entidad.PedidoProducto;

public interface RepositorioPedidoProducto {
    /**
     * Permite crear un pedido producto
     * @param pedidoProducto
     * @return el id generado
     */
    Long crear(PedidoProducto pedidoProducto);

    /**
     * Permite actualizar un pedido producto
     * @param pedidoProducto
     */
    void actualizar(PedidoProducto pedidoProducto);

    /**
     * Permite eliminar un pedido producto
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite eliminar un conjunto de productos asignados al pedido
     * @param id
     */
    void eliminarPedido(Long id);

    /**
     * Permite validar si existe un pedido producto con un id
     * @return si existe o no
     */
    boolean existePorId(Long id);

}
