package com.ceiba.pedido.modelo.entidad;


import com.ceiba.pedidoProducto.modelo.entidad.PedidoProducto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Pedido {

    private static final String SE_DEBE_INGRESAR_LA_FECHA = "Se debe ingresar la fecha";
    private static final String SE_DEBE_INGRESAR_PRODUCTOS = "Se debe ingresar productos";
    private Long id;
    private Date fecha;
    private BigDecimal domicilio;
    private List<PedidoProducto> lstProductos;

    public Pedido(Long id, Date fecha, BigDecimal domicilio, List<PedidoProducto> lstProductos) {
        validarObligatorio(fecha, SE_DEBE_INGRESAR_LA_FECHA);
        validarObligatorio(lstProductos, SE_DEBE_INGRESAR_PRODUCTOS);

        this.id = id;
        this.fecha = fecha;
        this.domicilio = domicilio;
        this.lstProductos = lstProductos;
    }
}
