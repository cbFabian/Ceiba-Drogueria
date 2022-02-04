package com.ceiba.pedido.comando;

import com.ceiba.pedidoProducto.modelo.entidad.PedidoProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPedido{

    private Long id;
    private String fecha;
    private BigDecimal domicilio;
    private List<PedidoProducto> lstProductos;
}
