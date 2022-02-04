package com.ceiba.festivos.modelo.entidad;


import lombok.Getter;

import java.util.Date;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Festivos {

    private static final String SE_DEBE_INGRESAR_LA_FECHA = "Se debe ingresar la fecha";
    private Long id;
    private Date fecha;

    public Festivos(Long id, Date fecha) {
        validarObligatorio(fecha, SE_DEBE_INGRESAR_LA_FECHA);

        this.id = id;
        this.fecha = fecha;
    }

}
