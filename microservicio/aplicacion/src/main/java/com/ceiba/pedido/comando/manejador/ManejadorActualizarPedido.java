package com.ceiba.pedido.comando.manejador;

import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.servicio.ServicioActualizarPedido;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.pedido.modelo.entidad.Pedido;
import org.springframework.stereotype.Component;

import com.ceiba.pedido.comando.fabrica.FabricaPedido;

@Component
public class ManejadorActualizarPedido implements ManejadorComando<ComandoPedido> {

    private final FabricaPedido fabricaPedido;
    private final ServicioActualizarPedido servicioActualizarPedido;

    public ManejadorActualizarPedido(FabricaPedido fabricaPedido, ServicioActualizarPedido servicioActualizarPedido) {
        this.fabricaPedido = fabricaPedido;
        this.servicioActualizarPedido = servicioActualizarPedido;
    }

    public void ejecutar(ComandoPedido comandoPedido) {
        Pedido pedido = this.fabricaPedido.crear(comandoPedido);
        this.servicioActualizarPedido.ejecutar(pedido);
    }
}
