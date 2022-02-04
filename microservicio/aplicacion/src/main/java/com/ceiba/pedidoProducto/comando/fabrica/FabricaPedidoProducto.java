package com.ceiba.pedidoProducto.comando.fabrica;

import com.ceiba.pedidoProducto.modelo.entidad.PedidoProducto;
import org.springframework.stereotype.Component;

import com.ceiba.pedidoProducto.comando.ComandoPedidoProducto;

@Component
public class FabricaPedidoProducto {

    public PedidoProducto crear(ComandoPedidoProducto comandoPedidoProducto) {
        return new PedidoProducto(
                comandoPedidoProducto.getId(),
                comandoPedidoProducto.getIdPedido(),
                comandoPedidoProducto.getIdProducto(),
                comandoPedidoProducto.getCantidad(),
                comandoPedidoProducto.getPrecio()
        );
    }

}
