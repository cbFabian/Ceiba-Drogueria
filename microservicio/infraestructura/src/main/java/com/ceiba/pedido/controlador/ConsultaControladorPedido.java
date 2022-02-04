package com.ceiba.pedido.controlador;

import java.util.List;

import com.ceiba.pedido.consulta.ManejadorListarPedido;
import com.ceiba.pedidoProducto.consulta.ManejadorListarPedidoProducto;
import com.ceiba.pedidoProducto.modelo.dto.DtoPedidoProducto;
import com.ceiba.producto.modelo.dto.DtoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.pedido.modelo.dto.DtoPedido;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pedido")
@Api(tags={"Controlador consulta pedidos"})
public class ConsultaControladorPedido {

    private final ManejadorListarPedido manejadorListarPedido;
    private final ManejadorListarPedidoProducto manejadorListarPedidoProducto;

    @Autowired
    public ConsultaControladorPedido(ManejadorListarPedido manejadorListarPedido, ManejadorListarPedidoProducto manejadorListarPedidoProducto) {
        this.manejadorListarPedido = manejadorListarPedido;
        this.manejadorListarPedidoProducto = manejadorListarPedidoProducto;
    }

    @GetMapping
    @ApiOperation("Listar Pedidos")
    public List<DtoPedido> listar() {
        List<DtoPedido> lista = this.manejadorListarPedido.ejecutar();
        for(DtoPedido dtoPedido : lista) {
            dtoPedido.setLstProductos(this.manejadorListarPedidoProducto.productos(dtoPedido.getId()));
        }
        return lista;
    }

    @GetMapping
    @RequestMapping("/id/{id}")
    @ApiOperation("Consultar Pedido")
    public DtoPedido producto(@PathVariable Long id) {
        DtoPedido pedido = this.manejadorListarPedido.pedido(id);
        List<DtoPedidoProducto> productos = this.manejadorListarPedidoProducto.productos(pedido.getId());
        pedido.setLstProductos(productos);
        return pedido;
    }

}
