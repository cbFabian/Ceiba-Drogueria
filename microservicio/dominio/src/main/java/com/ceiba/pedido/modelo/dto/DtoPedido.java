package com.ceiba.pedido.modelo.dto;

import com.ceiba.pedidoProducto.modelo.dto.DtoPedidoProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class DtoPedido {
    private Long id;
    private String fecha;
    private BigDecimal domicilio;
    private List<DtoPedidoProducto> lstProductos;

}
