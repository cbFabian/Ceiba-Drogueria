package com.ceiba.festivos.consulta;

import java.util.List;

import com.ceiba.festivos.puerto.dao.DaoFestivos;
import org.springframework.stereotype.Component;

import com.ceiba.festivos.modelo.dto.DtoFestivos;

@Component
public class ManejadorListarFestivos {

    private final DaoFestivos daoFestivos;

    public ManejadorListarFestivos(DaoFestivos daoFestivos){
        this.daoFestivos = daoFestivos;
    }

    public List<DtoFestivos> ejecutar(){ return this.daoFestivos.listar(); }
}
