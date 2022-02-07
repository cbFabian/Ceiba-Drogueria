package com.ceiba.usuario.servicio;

import com.ceiba.festivos.puerto.repositorio.RepositorioFestivos;
import com.ceiba.festivos.servicio.ServicioEliminarFestivos;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarFestivosTest {

    @Test
    @DisplayName("Deberia eliminar el festivo llamando al repositorio")
    void deberiaEliminarElFestivoLlamandoAlRepositorio() {
        RepositorioFestivos repositorioFestivos = Mockito.mock(RepositorioFestivos.class);
        ServicioEliminarFestivos servicioEliminarFestivos = new ServicioEliminarFestivos(repositorioFestivos);

        servicioEliminarFestivos.ejecutar(1l);

        Mockito.verify(repositorioFestivos, Mockito.times(1)).eliminar(1l);
    }

}
