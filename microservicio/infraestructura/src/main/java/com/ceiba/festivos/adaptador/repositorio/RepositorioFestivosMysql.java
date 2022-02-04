package com.ceiba.festivos.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.festivos.modelo.entidad.Festivos;
import com.ceiba.festivos.puerto.repositorio.RepositorioFestivos;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;

@Repository
public class RepositorioFestivosMysql implements RepositorioFestivos {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="festivos", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="festivos", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="festivos", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="festivos", value="existe")
    private static String sqlExiste = "SELECT COUNT(*) > 0 FROM festivos WHERE fecha = :fecha";

    @SqlStatement(namespace="festivos", value="existePorId")
    private static String sqlExistePorId;

    public RepositorioFestivosMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Festivos usuario) {
        return this.customNamedParameterJdbcTemplate.crear(usuario, sqlCrear);
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
        paramSource.addValue("fecha", sdf.format(fecha));

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Festivos usuario) {
        this.customNamedParameterJdbcTemplate.actualizar(usuario, sqlActualizar);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }
}
