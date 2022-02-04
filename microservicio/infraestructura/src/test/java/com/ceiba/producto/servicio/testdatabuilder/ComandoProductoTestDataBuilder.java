package com.ceiba.producto.servicio.testdatabuilder;

import com.ceiba.producto.comando.ComandoProducto;

import java.math.BigDecimal;

public class ComandoProductoTestDataBuilder {

    private Long id;
    private String nombre;
    private Integer cantidad;
    private BigDecimal precio;

    public ComandoProductoTestDataBuilder(String nombre) {
        this.nombre = nombre;
        cantidad = 200;
        precio = new BigDecimal(5000);
    }

    public ComandoProductoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoProducto build() {
        return new ComandoProducto(id, nombre, cantidad, precio);
    }
}
