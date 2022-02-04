package com.ceiba.pedido.adaptador.dao;

import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class MapeoPedido implements RowMapper<DtoPedido>, MapperResult {

    @Override
    public DtoPedido mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            Long id = resultSet.getLong("id");
            BigDecimal domicilio = resultSet.getBigDecimal("domicilio");
            String strFecha = resultSet.getString("fecha");
            Date fecha = sdf.parse(strFecha);
            return new DtoPedido(id, sdf2.format(fecha), domicilio, null);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
