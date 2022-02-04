package com.ceiba.producto.modelo.entidad;

import lombok.Getter;

import java.math.BigDecimal;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Producto {

    private static final String SE_DEBE_INGRESAR_LA_NOMBRE = "Se debe ingresar un nombre";
    private static final String SE_DEBE_INGRESAR_LA_CANTIDAD = "Se debe ingresar una cantidad";
    private static final String SE_DEBE_INGRESAR_LA_PRECIO = "Se debe ingresar un precio";
    private Long id;
    private String nombre;
    private Integer cantidad;
    private BigDecimal precio;

    public Producto(Long id, String nombre, Integer cantidad, BigDecimal precio) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_LA_NOMBRE);
        validarObligatorio(cantidad, SE_DEBE_INGRESAR_LA_CANTIDAD);
        validarObligatorio(precio, SE_DEBE_INGRESAR_LA_PRECIO);

        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

}
