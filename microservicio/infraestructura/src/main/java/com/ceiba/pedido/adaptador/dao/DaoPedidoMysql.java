package com.ceiba.pedido.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pedido.puerto.dao.DaoPedido;

import com.ceiba.producto.adaptador.dao.MapeoProducto;
import com.ceiba.producto.modelo.dto.DtoProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.pedido.modelo.dto.DtoPedido;

@Component
public class DaoPedidoMysql implements DaoPedido {

    @Autowired
    private CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="pedido", value="listar")
    private static String sqlListar = "";

    @SqlStatement(namespace="pedido", value="pedido")
    private static String sqlPedido = "";

    public DaoPedidoMysql() {
    }

    public DaoPedidoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPedido> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPedido());
    }

    @Override
    public DtoPedido pedido(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        List<DtoPedido> lista = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlPedido, params, new MapeoPedido());
        return lista.get(0);
    }
}
