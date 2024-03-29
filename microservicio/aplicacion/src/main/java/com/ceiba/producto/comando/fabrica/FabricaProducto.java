package com.ceiba.producto.comando.fabrica;

import com.ceiba.producto.modelo.entidad.Producto;
import org.springframework.stereotype.Component;

import com.ceiba.producto.comando.ComandoProducto;

@Component
public class FabricaProducto {

    public Producto crear(ComandoProducto comandoProducto) {
        return new Producto(
                comandoProducto.getId(),
                comandoProducto.getNombre(),
                comandoProducto.getCantidad(),
                comandoProducto.getPrecio()
        );
    }

}
