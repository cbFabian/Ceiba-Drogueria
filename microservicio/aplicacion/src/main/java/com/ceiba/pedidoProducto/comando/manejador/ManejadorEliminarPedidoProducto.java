package com.ceiba.pedidoProducto.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.pedidoProducto.servicio.ServicioEliminarPedidoProducto;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarPedidoProducto implements ManejadorComando<Long> {

    private final ServicioEliminarPedidoProducto servicioEliminarPedidoProducto;

    public ManejadorEliminarPedidoProducto(ServicioEliminarPedidoProducto servicioEliminarPedidoProducto) {
        this.servicioEliminarPedidoProducto = servicioEliminarPedidoProducto;
    }

    public void ejecutar(Long idUsuario) {
        this.servicioEliminarPedidoProducto.ejecutar(idUsuario);
    }
}
