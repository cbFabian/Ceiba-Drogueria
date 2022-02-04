package com.ceiba.pedidoProducto.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pedidoProducto.modelo.entidad.PedidoProducto;
import com.ceiba.pedidoProducto.puerto.repositorio.RepositorioPedidoProducto;
import com.ceiba.producto.adaptador.dao.MapeoProducto;
import com.ceiba.producto.modelo.dto.DtoProducto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioPedidoProductoMysql implements RepositorioPedidoProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="pedidoProducto", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="pedidoProducto", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="pedidoProducto", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="pedidoProducto", value="eliminarPedido")
    private static String sqlEliminarPedido;

    @SqlStatement(namespace="pedidoProducto", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioPedidoProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(PedidoProducto pedidoProducto) {
        return this.customNamedParameterJdbcTemplate.crear(pedidoProducto, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public void eliminarPedido(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idPedido", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarPedido, paramSource);
    }

    @Override
    public void actualizar(PedidoProducto pedidoProducto) {
        this.customNamedParameterJdbcTemplate.actualizar(pedidoProducto, sqlActualizar);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }

}
