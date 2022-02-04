package com.ceiba.pedidoProducto.adaptador.dao;

import com.ceiba.pedidoProducto.modelo.dto.DtoPedidoProducto;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.ResultSet;

public class MapeoPedidoProducto implements RowMapper<DtoPedidoProducto>, MapperResult {

    @Override
    public DtoPedidoProducto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        Long idPedido = resultSet.getLong("id_pedido");
        Long idProducto = resultSet.getLong("id_producto");
        Integer cantidad = resultSet.getInt("cantidad");
        BigDecimal precio = resultSet.getBigDecimal("precio");
        return new DtoPedidoProducto(id, idPedido, idProducto, cantidad, precio);
    }

}
