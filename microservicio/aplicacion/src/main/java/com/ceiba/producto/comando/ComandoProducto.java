package com.ceiba.producto.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoProducto {

    private Long id;
    private String nombre;
    private Integer cantidad;
    private BigDecimal precio;
}
