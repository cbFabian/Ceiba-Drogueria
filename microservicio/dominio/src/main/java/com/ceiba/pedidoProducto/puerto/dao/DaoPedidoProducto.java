package com.ceiba.pedidoProducto.puerto.dao;

import com.ceiba.pedidoProducto.modelo.dto.DtoPedidoProducto;

import java.util.List;

public interface DaoPedidoProducto {

    /**
     * Permite listar los pedidos de productos
     * @return pedidos de productos
     */
    List<DtoPedidoProducto> listar();

    /**
     * Permite listar los productos de un pedido
     * @return productos
     */
    List<DtoPedidoProducto> productos(Long id);
}
