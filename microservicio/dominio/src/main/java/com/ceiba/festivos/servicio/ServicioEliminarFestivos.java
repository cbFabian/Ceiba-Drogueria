package com.ceiba.festivos.servicio;

import com.ceiba.festivos.puerto.repositorio.RepositorioFestivos;

public class ServicioEliminarFestivos {

    private final RepositorioFestivos repositorioFestivos;

    public ServicioEliminarFestivos(RepositorioFestivos repositorioFestivos) {
        this.repositorioFestivos = repositorioFestivos;
    }

    public void ejecutar(Long id) {
        this.repositorioFestivos.eliminar(id);
    }
}
