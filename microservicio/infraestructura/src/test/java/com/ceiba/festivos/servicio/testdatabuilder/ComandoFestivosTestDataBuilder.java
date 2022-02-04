package com.ceiba.festivos.servicio.testdatabuilder;

import com.ceiba.festivos.comando.ComandoFestivos;
public class ComandoFestivosTestDataBuilder {

    private Long id;
    private String fecha;

    public ComandoFestivosTestDataBuilder(String fecha) {
        this.fecha = fecha;
    }

    public ComandoFestivos build() {
        return new ComandoFestivos(id, fecha);
    }
}
