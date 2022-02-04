package com.ceiba.festivos.controlador;

import java.util.List;

import com.ceiba.festivos.consulta.ManejadorListarFestivos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.festivos.modelo.dto.DtoFestivos;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/festivos")
@Api(tags={"Controlador consulta festivos"})
public class ConsultaControladorFestivos {

    private final ManejadorListarFestivos manejadorListarFestivos;

    @Autowired
    public ConsultaControladorFestivos(ManejadorListarFestivos manejadorListarFestivos) {
        this.manejadorListarFestivos = manejadorListarFestivos;
    }

    @GetMapping
    @ApiOperation("Listar Festivos")
    public List<DtoFestivos> listar() {
        return this.manejadorListarFestivos.ejecutar();
    }

}
