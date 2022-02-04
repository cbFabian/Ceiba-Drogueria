package com.ceiba.pedidoProducto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class DtoPedidoProducto {
    private Long id;
    private Long idPedido;
    private Long idProducto;
    private Integer cantidad;
    private BigDecimal precio;

}
