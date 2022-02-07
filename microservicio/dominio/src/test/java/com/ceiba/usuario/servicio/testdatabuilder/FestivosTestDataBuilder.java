package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.festivos.modelo.entidad.Festivos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FestivosTestDataBuilder {

    private Long id;
    private String fecha;

    public FestivosTestDataBuilder(Long id, String fecha) {
        this.id = id;
        this.fecha = fecha;
    }

    public Festivos build() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dtFecha;
        try {
            if (fecha != null) {
                dtFecha = sdf.parse(fecha);
            } else {
                dtFecha = null;
            }
        } catch (ParseException e) {
            dtFecha = null;
        }
        return new Festivos(id, dtFecha);
    }
}
