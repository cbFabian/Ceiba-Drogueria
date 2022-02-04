package com.ceiba.festivos.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.festivos.comando.ComandoFestivos;
import com.ceiba.festivos.comando.manejador.ManejadorActualizarFestivos;
import com.ceiba.festivos.comando.manejador.ManejadorCrearFestivos;
import com.ceiba.festivos.comando.manejador.ManejadorEliminarFestivos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/festivos")
@Api(tags = {"Controlador comando usuario"})
public class ComandoControladorFestivos {

    private final ManejadorCrearFestivos manejadorCrearFestivos;
    private final ManejadorEliminarFestivos manejadorEliminarFestivos;
    private final ManejadorActualizarFestivos manejadorActualizarFestivos;

    @Autowired
    public ComandoControladorFestivos(ManejadorCrearFestivos manejadorCrearFestivos,
                                      ManejadorEliminarFestivos manejadorEliminarFestivos,
                                      ManejadorActualizarFestivos manejadorActualizarFestivos) {
        this.manejadorCrearFestivos = manejadorCrearFestivos;
        this.manejadorEliminarFestivos = manejadorEliminarFestivos;
        this.manejadorActualizarFestivos = manejadorActualizarFestivos;
    }

    @PostMapping
    @ApiOperation("Crear Usuario")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoFestivos comandoFestivos) {
        return manejadorCrearFestivos.ejecutar(comandoFestivos);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar Usuario")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarFestivos.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Usuario")
    public void actualizar(@RequestBody ComandoFestivos comandoFestivos, @PathVariable Long id) {
        comandoFestivos.setId(id);
        manejadorActualizarFestivos.ejecutar(comandoFestivos);
    }
}
