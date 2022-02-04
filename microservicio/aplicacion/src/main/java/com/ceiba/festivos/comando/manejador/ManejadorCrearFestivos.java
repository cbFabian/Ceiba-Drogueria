package com.ceiba.festivos.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.festivos.comando.ComandoFestivos;
import com.ceiba.festivos.servicio.ServicioCrearFestivos;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.festivos.modelo.entidad.Festivos;
import org.springframework.stereotype.Component;

import com.ceiba.festivos.comando.fabrica.FabricaFestivos;

@Component
public class ManejadorCrearFestivos implements ManejadorComandoRespuesta<ComandoFestivos, ComandoRespuesta<Long>> {

    private final FabricaFestivos fabricaFestivos;
    private final ServicioCrearFestivos servicioCrearFestivos;

    public ManejadorCrearFestivos(FabricaFestivos fabricaFestivos, ServicioCrearFestivos servicioCrearFestivos) {
        this.fabricaFestivos = fabricaFestivos;
        this.servicioCrearFestivos = servicioCrearFestivos;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoFestivos comandoFestivos) {
        Festivos festivos = this.fabricaFestivos.crear(comandoFestivos);
        return new ComandoRespuesta<>(this.servicioCrearFestivos.ejecutar(festivos));
    }
}
