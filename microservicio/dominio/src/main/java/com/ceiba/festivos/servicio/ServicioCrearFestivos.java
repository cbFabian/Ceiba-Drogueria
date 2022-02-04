package com.ceiba.festivos.servicio;

import com.ceiba.festivos.modelo.entidad.Festivos;
import com.ceiba.festivos.puerto.repositorio.RepositorioFestivos;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioCrearFestivos {

    private static final String EL_FESTIVO_YA_EXISTE_EN_EL_SISTEMA = "El festivo ya existe en el sistema";

    private final RepositorioFestivos repositorioFestivos;

    public ServicioCrearFestivos(RepositorioFestivos repositorioFestivos) {
        this.repositorioFestivos = repositorioFestivos;
    }

    public Long ejecutar(Festivos festivos) {
        validarExistenciaPrevia(festivos);
        return this.repositorioFestivos.crear(festivos);
    }

    private void validarExistenciaPrevia(Festivos festivos) {
        boolean existe = this.repositorioFestivos.existe(festivos.getFecha());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_FESTIVO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
