package com.ceiba.pedidoProducto.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPedidoProducto {

    private Long id;
    private Long idPedido;
    private Long idProducto;
    private Integer cantidad;
    private BigDecimal precio;
}
