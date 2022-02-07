package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.festivos.modelo.entidad.Festivos;
import com.ceiba.festivos.puerto.repositorio.RepositorioFestivos;
import com.ceiba.festivos.servicio.ServicioCrearFestivos;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.FestivosTestDataBuilder;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearFestivoTest {

    @Test
    @DisplayName("Deberia lanzar una exepecion cuando la fecha sea null")
    void deberiaLanzarUnaExepcionCuandoLaFechaSeaNull() {
        // arrange
        FestivosTestDataBuilder festivosTestDataBuilder = new FestivosTestDataBuilder(null, null);
        // act - assert
        BasePrueba.assertThrows(festivosTestDataBuilder::build, ExcepcionValorObligatorio.class, "Se debe ingresar la fecha");
    }

    @Test
    @DisplayName("Deberia Crear el festivo de manera correcta")
    void deberiaCrearElFstivoDeManeraCorrecta() {
        // arrange
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Festivos festivos = new FestivosTestDataBuilder(10L, "08/02/2022").build();
        RepositorioFestivos repositorioFestivos = Mockito.mock(RepositorioFestivos.class);
        Date dtFecha;
        try {
            dtFecha = sdf.parse("08/02/2022");
        } catch (ParseException e) {
            dtFecha = null;
        }
        Mockito.when(repositorioFestivos.existe(dtFecha)).thenReturn(false);
        Mockito.when(repositorioFestivos.crear(festivos)).thenReturn(10L);
        ServicioCrearFestivos servicioCrearFestivos = new ServicioCrearFestivos(repositorioFestivos);
        // act
        Long id = servicioCrearFestivos.ejecutar(festivos);
        //- assert
        assertEquals(10L, id);
        Mockito.verify(repositorioFestivos, Mockito.times(1)).crear(festivos);
    }
}
