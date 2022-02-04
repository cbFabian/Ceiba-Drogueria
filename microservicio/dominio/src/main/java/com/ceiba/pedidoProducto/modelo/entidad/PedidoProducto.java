package com.ceiba.pedidoProducto.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class PedidoProducto {

    private static final String SE_DEBE_INGRESAR_PEDIDO = "Se debe ingresar un pedido";
    private static final String SE_DEBE_INGRESAR_PRODUCTO = "Se debe ingresar un producto";
    private static final String SE_DEBE_INGRESAR_CANTIDAD = "Se debe ingresar una cantidad";
    private static final String SE_DEBE_INGRESAR_PRECIO = "Se debe ingresar un precio";
    private Long id;
    private Long idPedido;
    private Long idProducto;
    private Integer cantidad;
    private BigDecimal precio;

    public PedidoProducto(Long id, Long idPedido, Long idProducto, Integer cantidad, BigDecimal precio) {
        validarObligatorio(idPedido, SE_DEBE_INGRESAR_PEDIDO);
        validarObligatorio(idProducto, SE_DEBE_INGRESAR_PRODUCTO);
        validarObligatorio(cantidad, SE_DEBE_INGRESAR_CANTIDAD);
        validarObligatorio(precio, SE_DEBE_INGRESAR_PRECIO);

        this.id = id;
        this.idPedido = idPedido;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public PedidoProducto() {
    }
}
