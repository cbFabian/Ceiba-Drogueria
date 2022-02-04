package com.ceiba.pedido.puerto.repositorio;

import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;

import java.util.Date;

public interface RepositorioPedido {
    /**
     * Permite crear un pedido
     * @param pedido
     * @return el id generado
     */
    Long crear(Pedido pedido);

    /**
     * Permite actualizar un pedido
     * @param pedido
     */
    void actualizar(Pedido pedido);

    /**
     * Permite eliminar un pedido
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un pedido con un esa fecha
     * @param fecha
     * @return si existe o no
     */
    boolean existe(Date fecha);

    /**
     * Permite validar si existe un pedido con un id
     * @return si existe o no
     */
    boolean existePorId(Long id);

    /**
     * Permite buscar por id el pedido
     * @return pedido
     */
    DtoPedido pedido(Long id);

}
