package com.ceiba.producto.servicio;

import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioCrearProducto {

    private static final String EL_FESTIVO_YA_EXISTE_EN_EL_SISTEMA = "El producto ya existe en el sistema";

    private final RepositorioProducto repositorioProducto;

    public ServicioCrearProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public Long ejecutar(Producto producto) {
        validarExistenciaPrevia(producto);
        return this.repositorioProducto.crear(producto);
    }

    private void validarExistenciaPrevia(Producto producto) {
        boolean existe = this.repositorioProducto.existe(producto.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_FESTIVO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
