package com.ceiba.producto.puerto.dao;

import com.ceiba.producto.modelo.dto.DtoProducto;

import java.util.List;

public interface DaoProducto {

    /**
     * Permite listar los productos
     * @return los productos
     */
    List<DtoProducto> listar();

    /**
     * Permite buscar producto por id
     * @return producto
     */
    DtoProducto producto(Long id);
}
