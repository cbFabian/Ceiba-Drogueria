package com.ceiba.pedidoProducto.controlador;

import java.util.List;

import com.ceiba.pedidoProducto.consulta.ManejadorListarPedidoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.pedidoProducto.modelo.dto.DtoPedidoProducto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pedidoProducto")
@Api(tags={"Controlador consulta pedidoProducto"})
public class ConsultaControladorPedidoProducto {

    private final ManejadorListarPedidoProducto manejadorListarPedidoProducto;

    @Autowired
    public ConsultaControladorPedidoProducto(ManejadorListarPedidoProducto manejadorListarPedidoProducto) {
        this.manejadorListarPedidoProducto = manejadorListarPedidoProducto;
    }

    @GetMapping
    @ApiOperation("Listar pedidoProducto")
    public List<DtoPedidoProducto> listar() {
        return this.manejadorListarPedidoProducto.ejecutar();
    }

}
