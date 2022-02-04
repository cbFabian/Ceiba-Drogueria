package com.ceiba.producto.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.producto.puerto.dao.DaoProducto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.producto.modelo.dto.DtoProducto;

@Component
public class DaoProductoMysql implements DaoProducto {

    @Autowired
    private CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="producto", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="producto", value="producto")
    private static String sqlProducto;

    public DaoProductoMysql() {
    }

    public DaoProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoProducto> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoProducto());
    }

    @Override
    public DtoProducto producto(Long id) {
        DtoProducto dto = new DtoProducto(id, null, null, null);
        MapSqlParameterSource params = this.customNamedParameterJdbcTemplate.crearParametros(dto);
        List<DtoProducto> lista = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlProducto, params, new MapeoProducto());
        return lista.get(0);
    }
}
