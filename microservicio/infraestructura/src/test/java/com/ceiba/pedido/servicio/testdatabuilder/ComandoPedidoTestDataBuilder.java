package com.ceiba.pedido.servicio.testdatabuilder;

import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedidoProducto.modelo.entidad.PedidoProducto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ComandoPedidoTestDataBuilder {

    private Long id;
    private String fecha;
    private BigDecimal domicilio;
    private List<PedidoProducto> lstProductos;

    public ComandoPedidoTestDataBuilder(String fecha) {
        this.fecha = fecha;
        this.lstProductos = new ArrayList<>();
        PedidoProducto pedidoProducto = new PedidoProducto();
        pedidoProducto.setIdProducto(Long.getLong("1"));
        pedidoProducto.setPrecio(new BigDecimal("5000"));
        pedidoProducto.setCantidad(10);

        this.lstProductos.add(pedidoProducto);
    }

    public ComandoPedido build() {
        return new ComandoPedido(id, fecha, domicilio, lstProductos);
    }
}
