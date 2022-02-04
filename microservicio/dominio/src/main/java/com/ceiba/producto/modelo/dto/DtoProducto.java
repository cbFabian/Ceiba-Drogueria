package com.ceiba.producto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class DtoProducto {
    private Long id;
    private String nombre;
    private Integer cantidad;
    private BigDecimal precio;

}
