package com.ceiba.pedidoProducto.consulta;

import java.util.List;

import com.ceiba.pedidoProducto.puerto.dao.DaoPedidoProducto;
import org.springframework.stereotype.Component;

import com.ceiba.pedidoProducto.modelo.dto.DtoPedidoProducto;

@Component
public class ManejadorListarPedidoProducto {

    private final DaoPedidoProducto daoPedidoProducto;

    public ManejadorListarPedidoProducto(DaoPedidoProducto daoPedidoProducto){
        this.daoPedidoProducto = daoPedidoProducto;
    }

    public List<DtoPedidoProducto> ejecutar(){ return this.daoPedidoProducto.listar(); }

    public List<DtoPedidoProducto> productos(Long id){ return this.daoPedidoProducto.productos(id); }
}
