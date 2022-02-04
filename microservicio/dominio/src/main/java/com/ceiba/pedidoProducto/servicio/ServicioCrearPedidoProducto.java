package com.ceiba.pedidoProducto.servicio;

import com.ceiba.pedidoProducto.modelo.entidad.PedidoProducto;
import com.ceiba.pedidoProducto.puerto.repositorio.RepositorioPedidoProducto;

public class ServicioCrearPedidoProducto {

    private final RepositorioPedidoProducto repositorioPedidoProducto;

    public ServicioCrearPedidoProducto(RepositorioPedidoProducto repositorioPedidoProducto) {
        this.repositorioPedidoProducto = repositorioPedidoProducto;
    }

    public Long ejecutar(PedidoProducto pedidoProducto) {
        return this.repositorioPedidoProducto.crear(pedidoProducto);
    }
}
