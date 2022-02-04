package com.ceiba.festivos.adaptador.dao;

import com.ceiba.festivos.modelo.dto.DtoFestivos;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class MapeoFestivos implements RowMapper<DtoFestivos>, MapperResult {

    @Override
    public DtoFestivos mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

            Long id = resultSet.getLong("id");
            String strFecha = resultSet.getString("fecha");
            Date fecha = sdf.parse(strFecha);
            return new DtoFestivos(id, sdf2.format(fecha));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
