package com.ceiba.pedidoProducto.comando.manejador;

import com.ceiba.pedidoProducto.comando.ComandoPedidoProducto;
import com.ceiba.pedidoProducto.servicio.ServicioActualizarPedidoProducto;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.pedidoProducto.modelo.entidad.PedidoProducto;
import org.springframework.stereotype.Component;

import com.ceiba.pedidoProducto.comando.fabrica.FabricaPedidoProducto;

@Component
public class ManejadorActualizarPedidoProducto implements ManejadorComando<ComandoPedidoProducto> {

    private final FabricaPedidoProducto fabricaPedidoProducto;
    private final ServicioActualizarPedidoProducto servicioActualizarPedidoProducto;

    public ManejadorActualizarPedidoProducto(FabricaPedidoProducto fabricaPedidoProducto, ServicioActualizarPedidoProducto servicioActualizarPedidoProducto) {
        this.fabricaPedidoProducto = fabricaPedidoProducto;
        this.servicioActualizarPedidoProducto = servicioActualizarPedidoProducto;
    }

    public void ejecutar(ComandoPedidoProducto comandoPedidoProducto) {
        PedidoProducto pedidoProducto = this.fabricaPedidoProducto.crear(comandoPedidoProducto);
        this.servicioActualizarPedidoProducto.ejecutar(pedidoProducto);
    }
}
