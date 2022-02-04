package com.ceiba.festivos.comando.manejador;

import com.ceiba.festivos.comando.ComandoFestivos;
import com.ceiba.festivos.servicio.ServicioActualizarFestivos;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.festivos.modelo.entidad.Festivos;
import org.springframework.stereotype.Component;

import com.ceiba.festivos.comando.fabrica.FabricaFestivos;

@Component
public class ManejadorActualizarFestivos implements ManejadorComando<ComandoFestivos> {

    private final FabricaFestivos fabricaFestivos;
    private final ServicioActualizarFestivos servicioActualizarFestivos;

    public ManejadorActualizarFestivos(FabricaFestivos fabricaFestivos, ServicioActualizarFestivos servicioActualizarFestivos) {
        this.fabricaFestivos = fabricaFestivos;
        this.servicioActualizarFestivos = servicioActualizarFestivos;
    }

    public void ejecutar(ComandoFestivos comandoFestivos) {
        Festivos festivos = this.fabricaFestivos.crear(comandoFestivos);
        this.servicioActualizarFestivos.ejecutar(festivos);
    }
}
