package com.ceiba.usuario.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.servicio.testdatabuilder.PedidoTestDataBuilder;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidoTest {

    @Test
    @DisplayName("Deberia crear correctamente un Pedido")
    void deberiaCrearCorrectamenteUnPedido() {
        // arrange
        Date fechaCreacion = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //act
        Pedido pedido = new PedidoTestDataBuilder(1L, sdf.format(fechaCreacion)).build();
        //assert
        assertEquals(1, pedido.getId());
        assertEquals(sdf.format(fechaCreacion), sdf.format(pedido.getFecha()));
    }

    @Test
    void deberiaFallarSinFecha() {

        //Arrange
        PedidoTestDataBuilder pedidoTestDataBuilder = new PedidoTestDataBuilder(null, null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    pedidoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha");
    }

    @Test
    void deberiaFallarSinProductos() {

        //Arrange
        PedidoTestDataBuilder pedidoTestDataBuilder = new PedidoTestDataBuilder();
        //act-assert
        BasePrueba.assertThrows(() -> {
                    pedidoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar productos");
    }

}
