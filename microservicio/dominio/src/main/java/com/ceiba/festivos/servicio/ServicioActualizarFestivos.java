package com.ceiba.festivos.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.festivos.modelo.entidad.Festivos;
import com.ceiba.festivos.puerto.repositorio.RepositorioFestivos;

public class ServicioActualizarFestivos {

    private static final String EL_FESTIVO_NO_EXISTE_EN_EL_SISTEMA = "El festivo no existe en el sistema";

    private final RepositorioFestivos repositorioFestivos;

    public ServicioActualizarFestivos(RepositorioFestivos repositorioUsuario) {
        this.repositorioFestivos = repositorioUsuario;
    }

    public void ejecutar(Festivos festivos) {
        validarExistenciaPrevia(festivos);
        this.repositorioFestivos.actualizar(festivos);
    }

    private void validarExistenciaPrevia(Festivos festivos) {
        boolean existe = this.repositorioFestivos.existePorId(festivos.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_FESTIVO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
