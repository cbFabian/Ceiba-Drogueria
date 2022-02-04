package com.ceiba.pedidoProducto.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.pedidoProducto.comando.ComandoPedidoProducto;
import com.ceiba.pedidoProducto.servicio.ServicioCrearPedidoProducto;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.pedidoProducto.modelo.entidad.PedidoProducto;
import org.springframework.stereotype.Component;

import com.ceiba.pedidoProducto.comando.fabrica.FabricaPedidoProducto;

@Component
public class ManejadorCrearPedidoProducto implements ManejadorComandoRespuesta<ComandoPedidoProducto, ComandoRespuesta<Long>> {

    private final FabricaPedidoProducto fabricaPedidoProducto;
    private final ServicioCrearPedidoProducto servicioCrearPedidoProducto;

    public ManejadorCrearPedidoProducto(FabricaPedidoProducto fabricaPedidoProducto, ServicioCrearPedidoProducto servicioCrearPedidoProducto) {
        this.fabricaPedidoProducto = fabricaPedidoProducto;
        this.servicioCrearPedidoProducto = servicioCrearPedidoProducto;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoPedidoProducto comandoPedidoProducto) {
        PedidoProducto pedidoProducto = this.fabricaPedidoProducto.crear(comandoPedidoProducto);
        return new ComandoRespuesta<>(this.servicioCrearPedidoProducto.ejecutar(pedidoProducto));
    }
}
