package com.ceiba.pedido.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pedido.adaptador.dao.MapeoPedido;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class RepositorioPedidoMysql implements RepositorioPedido {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="pedido", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="pedido", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="pedido", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="pedido", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="pedido", value="existePorId")
    private static String sqlExistePorId;

    @SqlStatement(namespace="pedido", value="pedido")
    private static String sqlPedido;

    public RepositorioPedidoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Pedido pedido) {
        return this.customNamedParameterJdbcTemplate.crear(pedido, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("fecha", fecha);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Pedido pedido) {
        this.customNamedParameterJdbcTemplate.actualizar(pedido, sqlActualizar);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }

    @Override
    public DtoPedido pedido(Long id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        List<DtoPedido> lista = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlPedido, params, new MapeoPedido());
        return lista.get(0);
    }
}
