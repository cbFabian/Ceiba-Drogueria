package com.ceiba.producto.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.producto.comando.ComandoProducto;
import com.ceiba.producto.servicio.ServicioCrearProducto;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.producto.modelo.entidad.Producto;
import org.springframework.stereotype.Component;

import com.ceiba.producto.comando.fabrica.FabricaProducto;

@Component
public class ManejadorCrearProducto implements ManejadorComandoRespuesta<ComandoProducto, ComandoRespuesta<Long>> {

    private final FabricaProducto fabricaProducto;
    private final ServicioCrearProducto servicioCrearProducto;

    public ManejadorCrearProducto(FabricaProducto fabricaProducto, ServicioCrearProducto servicioCrearProducto) {
        this.fabricaProducto = fabricaProducto;
        this.servicioCrearProducto = servicioCrearProducto;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoProducto comandoProducto) {
        Producto producto = this.fabricaProducto.crear(comandoProducto);
        return new ComandoRespuesta<>(this.servicioCrearProducto.ejecutar(producto));
    }
}
