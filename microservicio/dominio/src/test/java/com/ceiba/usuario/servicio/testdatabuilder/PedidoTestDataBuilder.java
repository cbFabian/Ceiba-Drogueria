package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedidoProducto.modelo.entidad.PedidoProducto;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoTestDataBuilder {

    private Long id;
    private String fecha;
    private BigDecimal domicilio;
    private List<PedidoProducto> lstProductos;

    public PedidoTestDataBuilder(Long id, String fecha) {
        this.id = id;
        this.fecha = fecha;
        this.lstProductos = new ArrayList<>();
        PedidoProducto pedidoProducto = new PedidoProducto();
        pedidoProducto.setIdProducto(Long.getLong("1"));
        pedidoProducto.setPrecio(new BigDecimal("5000"));
        pedidoProducto.setCantidad(10);

        this.lstProductos.add(pedidoProducto);
    }

    public PedidoTestDataBuilder() {
        this.fecha = "20/02/2022";
    }

    public Pedido build() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dtFecha;
        try {
            if (fecha != null) {
                dtFecha = sdf.parse(fecha);
            } else {
                dtFecha = null;
            }
        } catch (ParseException e) {
            dtFecha = null;
        }
        return new Pedido(id, dtFecha, domicilio, lstProductos);
    }
}
