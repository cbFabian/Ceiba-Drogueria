package com.ceiba.pedidoProducto.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pedido.adaptador.dao.MapeoPedido;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedidoProducto.puerto.dao.DaoPedidoProducto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.pedidoProducto.modelo.dto.DtoPedidoProducto;

@Component
public class DaoPedidoProductoMysql implements DaoPedidoProducto {

    @Autowired
    private CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="pedidoProducto", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="pedidoProducto", value="productos")
    private static String sqlProductos;

    public DaoPedidoProductoMysql() {
    }

    public DaoPedidoProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPedidoProducto> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPedidoProducto());
    }

    @Override
    public List<DtoPedidoProducto> productos(Long id) {
        DtoPedidoProducto dto = new DtoPedidoProducto(id, null, null, null, null);
        MapSqlParameterSource params = this.customNamedParameterJdbcTemplate.crearParametros(dto);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlProductos, params, new MapeoPedidoProducto());
    }
}
