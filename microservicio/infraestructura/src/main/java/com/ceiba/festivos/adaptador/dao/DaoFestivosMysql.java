package com.ceiba.festivos.adaptador.dao;

import java.util.List;

import com.ceiba.festivos.puerto.dao.DaoFestivos;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.festivos.modelo.dto.DtoFestivos;

@Component
public class DaoFestivosMysql implements DaoFestivos {

    @Autowired
    private CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="festivos", value="listar")
    private static String sqlListar = "SELECT id, fecha FROM festivos";

    public DaoFestivosMysql() {
    }

    public DaoFestivosMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoFestivos> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoFestivos());
    }
}
