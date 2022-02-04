package com.ceiba.pedidoProducto.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.pedidoProducto.comando.ComandoPedidoProducto;
import com.ceiba.pedidoProducto.comando.manejador.ManejadorActualizarPedidoProducto;
import com.ceiba.pedidoProducto.comando.manejador.ManejadorCrearPedidoProducto;
import com.ceiba.pedidoProducto.comando.manejador.ManejadorEliminarPedidoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pedidoProducto")
@Api(tags = {"Controlador comando pedidoProducto"})
public class ComandoControladorPedidoProducto {

    private final ManejadorCrearPedidoProducto manejadorCrearPedidoProducto;
    private final ManejadorEliminarPedidoProducto manejadorEliminarPedidoProducto;
    private final ManejadorActualizarPedidoProducto manejadorActualizarPedidoProducto;

    @Autowired
    public ComandoControladorPedidoProducto(ManejadorCrearPedidoProducto manejadorCrearPedidoProducto,
                                            ManejadorEliminarPedidoProducto manejadorEliminarPedidoProducto,
                                            ManejadorActualizarPedidoProducto manejadorActualizarPedidoProducto) {
        this.manejadorCrearPedidoProducto = manejadorCrearPedidoProducto;
        this.manejadorEliminarPedidoProducto = manejadorEliminarPedidoProducto;
        this.manejadorActualizarPedidoProducto = manejadorActualizarPedidoProducto;
    }

    @PostMapping
    @ApiOperation("Crear Usuario")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPedidoProducto comandoPedidoProducto) {
        return manejadorCrearPedidoProducto.ejecutar(comandoPedidoProducto);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar Usuario")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarPedidoProducto.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Usuario")
    public void actualizar(@RequestBody ComandoPedidoProducto comandoPedidoProducto, @PathVariable Long id) {
        comandoPedidoProducto.setId(id);
        manejadorActualizarPedidoProducto.ejecutar(comandoPedidoProducto);
    }
}
