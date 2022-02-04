package com.ceiba.producto.controlador;

import java.util.List;

import com.ceiba.producto.consulta.ManejadorListarProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.producto.modelo.dto.DtoProducto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/producto")
@Api(tags={"Controlador consulta Producto"})
public class ConsultaControladorProducto {

    private final ManejadorListarProducto manejadorListarProducto;

    @Autowired
    public ConsultaControladorProducto(ManejadorListarProducto manejadorListarProducto) {
        this.manejadorListarProducto = manejadorListarProducto;
    }

    @GetMapping
    @ApiOperation("Listar Producto")
    public List<DtoProducto> listar() {
        return this.manejadorListarProducto.ejecutar();
    }

    @GetMapping
    @RequestMapping("/id/{id}")
    @ApiOperation("Consultar Producto")
    public DtoProducto producto(@PathVariable Long id) {
        return this.manejadorListarProducto.producto(id);
    }

}
