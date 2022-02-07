package com.ceiba.usuario.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.festivos.modelo.entidad.Festivos;
import com.ceiba.usuario.servicio.testdatabuilder.FestivosTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FestivosTest {

    @Test
    @DisplayName("Deberia crear correctamente el festivo")
    void deberiaCrearCorrectamenteElFestivo() {
        // arrange
        Date fechaCreacion = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //act
        Festivos festivos = new FestivosTestDataBuilder(1L,sdf.format(fechaCreacion)).build();

        //assert
        assertEquals(1, festivos.getId());
        assertEquals(sdf.format(fechaCreacion), sdf.format(festivos.getFecha()));
    }

    @Test
    void deberiaFallarSinFecha() {

        //Arrange
        FestivosTestDataBuilder festivosTestDataBuilder = new FestivosTestDataBuilder(null, null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    festivosTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha");
    }

}
