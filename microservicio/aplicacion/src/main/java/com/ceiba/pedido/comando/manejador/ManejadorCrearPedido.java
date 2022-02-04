package com.ceiba.pedido.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.servicio.ServicioCrearPedido;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.pedido.modelo.entidad.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.pedido.comando.fabrica.FabricaPedido;

@Component
public class ManejadorCrearPedido implements ManejadorComandoRespuesta<ComandoPedido, ComandoRespuesta<Long>> {

    @Autowired
    private FabricaPedido fabricaPedido;

    @Autowired
    private ServicioCrearPedido servicioCrearPedido;

    public ManejadorCrearPedido() {
    }

    public ManejadorCrearPedido(FabricaPedido fabricaPedido, ServicioCrearPedido servicioCrearPedido) {
        this.fabricaPedido = fabricaPedido;
        this.servicioCrearPedido = servicioCrearPedido;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoPedido comandoPedido) {
        Pedido pedido = this.fabricaPedido.crear(comandoPedido);
        return new ComandoRespuesta<>(this.servicioCrearPedido.ejecutar(pedido));
    }
}
