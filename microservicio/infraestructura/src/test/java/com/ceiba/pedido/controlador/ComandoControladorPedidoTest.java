package com.ceiba.pedido.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.pedido.comando.ComandoPedido;
import com.ceiba.pedido.servicio.testdatabuilder.ComandoPedidoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorPedido.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorPedidoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear un pedido")
    void deberiaCrearUnPedido() throws Exception{
        // arrange
        ComandoPedido pedido = new ComandoPedidoTestDataBuilder("2022-01-25 07:30:00").build();
        // act - assert
        mocMvc.perform(post("/pedido")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pedido)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    @DisplayName("Deberia validar sabado domingo")
    void deberiaValidarSabadoDomingo() throws Exception{
        // arrange
        ComandoPedido pedido = new ComandoPedidoTestDataBuilder("2022-01-29 07:30:00").build();
        // act - assert
        mocMvc.perform(post("/pedido")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pedido)))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.mensaje", is("No se realiza atención los dias sabados ni domingos")));
    }

    @Test
    @DisplayName("Deberia validar festivos")
    void deberiaValidarFestivos() throws Exception{
        // arrange
        ComandoPedido pedido = new ComandoPedidoTestDataBuilder("2022-01-10 07:30:00").build();
        // act - assert
        mocMvc.perform(post("/pedido")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(pedido)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

}
