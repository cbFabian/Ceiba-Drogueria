package com.ceiba.festivos.puerto.repositorio;

import com.ceiba.festivos.modelo.entidad.Festivos;

import java.util.Date;

public interface RepositorioFestivos {
    /**
     * Permite crear un dia festivo
     * @param festivos
     * @return el id generado
     */
    Long crear(Festivos festivos);

    /**
     * Permite actualizar un dia festivo
     * @param festivos
     */
    void actualizar(Festivos festivos);

    /**
     * Permite eliminar un dia festivo
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un dia festivo con un esa fecha
     * @param fecha
     * @return si existe o no
     */
    boolean existe(Date fecha);

    /**
     * Permite validar si existe un dia festivo con un id
     * @return si existe o no
     */
    boolean existePorId(Long id);

}
