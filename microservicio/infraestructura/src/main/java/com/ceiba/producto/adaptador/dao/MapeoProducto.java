package com.ceiba.producto.adaptador.dao;

import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.ResultSet;

public class MapeoProducto implements RowMapper<DtoProducto>, MapperResult {

    @Override
    public DtoProducto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        Integer cantidad = resultSet.getInt("cantidad");
        BigDecimal precio = resultSet.getBigDecimal("precio");
        return new DtoProducto(id, nombre, cantidad, precio);
    }

}
