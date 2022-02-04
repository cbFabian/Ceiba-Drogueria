package com.ceiba.festivos.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.festivos.servicio.ServicioEliminarFestivos;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarFestivos implements ManejadorComando<Long> {

    private final ServicioEliminarFestivos servicioEliminarFestivos;

    public ManejadorEliminarFestivos(ServicioEliminarFestivos servicioEliminarFestivos) {
        this.servicioEliminarFestivos = servicioEliminarFestivos;
    }

    public void ejecutar(Long idUsuario) {
        this.servicioEliminarFestivos.ejecutar(idUsuario);
    }
}
