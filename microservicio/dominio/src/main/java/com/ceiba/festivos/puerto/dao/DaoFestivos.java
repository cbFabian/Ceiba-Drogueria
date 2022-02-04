package com.ceiba.festivos.puerto.dao;

import com.ceiba.festivos.modelo.dto.DtoFestivos;

import java.util.List;

public interface DaoFestivos {

    /**
     * Permite listar dias festivos
     * @return los dias festivos
     */
    List<DtoFestivos> listar();
}
