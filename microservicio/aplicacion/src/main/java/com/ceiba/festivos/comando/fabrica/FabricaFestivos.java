package com.ceiba.festivos.comando.fabrica;

import com.ceiba.festivos.modelo.entidad.Festivos;
import org.springframework.stereotype.Component;

import com.ceiba.festivos.comando.ComandoFestivos;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class FabricaFestivos {

    public Festivos crear(ComandoFestivos comandoFestivos) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return new Festivos(
                    comandoFestivos.getId(),
                    sdf.parse(comandoFestivos.getFechaCreacion())
            );
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
