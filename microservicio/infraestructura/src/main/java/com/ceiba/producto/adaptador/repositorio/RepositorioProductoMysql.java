package com.ceiba.producto.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.producto.adaptador.dao.MapeoProducto;
import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public class RepositorioProductoMysql implements RepositorioProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="producto", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="producto", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="producto", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="producto", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="producto", value="existePorId")
    private static String sqlExistePorId;

    @SqlStatement(namespace="producto", value="producto")
    private static String sqlProducto;

    public RepositorioProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Producto producto) {
        return this.customNamedParameterJdbcTemplate.crear(producto, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String nombre) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Producto producto) {
        this.customNamedParameterJdbcTemplate.actualizar(producto, sqlActualizar);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }
}
