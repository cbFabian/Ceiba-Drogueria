package com.ceiba.pedidoProducto.servicio;

import com.ceiba.pedidoProducto.puerto.repositorio.RepositorioPedidoProducto;

public class ServicioEliminarPedidoProducto {

    private final RepositorioPedidoProducto repositorioPedidoProducto;

    public ServicioEliminarPedidoProducto(RepositorioPedidoProducto repositorioPedidoProducto) {
        this.repositorioPedidoProducto = repositorioPedidoProducto;
    }

    public void ejecutar(Long id) {
        this.repositorioPedidoProducto.eliminar(id);
    }
}
