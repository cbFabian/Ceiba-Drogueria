package com.ceiba.producto.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.comando.manejador.ManejadorActualizarProducto;
import com.ceiba.producto.comando.manejador.ManejadorCrearProducto;
import com.ceiba.producto.comando.manejador.ManejadorEliminarProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/producto")
@Api(tags = {"Controlador comando Producto"})
public class ComandoControladorProducto {

    private final ManejadorCrearProducto manejadorCrearProducto;
    private final ManejadorEliminarProducto manejadorEliminarProducto;
    private final ManejadorActualizarProducto manejadorActualizarProducto;

    @Autowired
    public ComandoControladorProducto(ManejadorCrearProducto manejadorCrearProducto,
                                      ManejadorEliminarProducto manejadorEliminarProducto,
                                      ManejadorActualizarProducto manejadorActualizarProducto) {
        this.manejadorCrearProducto = manejadorCrearProducto;
        this.manejadorEliminarProducto = manejadorEliminarProducto;
        this.manejadorActualizarProducto = manejadorActualizarProducto;
    }

    @PostMapping
    @ApiOperation("Crear Producto")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoProducto comandoProducto) {
        return manejadorCrearProducto.ejecutar(comandoProducto);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar Producto")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarProducto.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Producto")
    public void actualizar(@RequestBody ComandoProducto comandoProducto, @PathVariable Long id) {
        comandoProducto.setId(id);
        manejadorActualizarProducto.ejecutar(comandoProducto);
    }
}
