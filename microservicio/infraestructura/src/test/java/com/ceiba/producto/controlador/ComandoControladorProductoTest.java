package com.ceiba.producto.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.servicio.testdatabuilder.ComandoProductoTestDataBuilder;
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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorProducto.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorProductoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear un producto")
    void deberiaCrearUnProducto() throws Exception {
        // arrange
        ComandoProducto producto = new ComandoProductoTestDataBuilder("Seda Dental").build();
        // act - assert
        mocMvc.perform(post("/producto")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(producto)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    @DisplayName("Deberia actualizar un producto")
    void deberiaActualizarUnProducto() throws Exception {
        // arrange
        Long id = 1L;
        ComandoProducto producto = new ComandoProductoTestDataBuilder("Agua").build();
        // act - assert
        mocMvc.perform(put("/producto/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(producto)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia dar error por duplicidad")
    void deberiaDarErrorDuplicidad() throws Exception {
        // arrange
        ComandoProducto producto = new ComandoProductoTestDataBuilder("Arroz").build();
        // act - assert
        mocMvc.perform(post("/producto")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(producto)))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.mensaje", is("El producto ya existe en el sistema")));
    }


}
