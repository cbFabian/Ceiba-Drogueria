package com.ceiba.pedido.comando.fabrica;

import com.ceiba.pedido.modelo.entidad.Pedido;
import org.springframework.stereotype.Component;

import com.ceiba.pedido.comando.ComandoPedido;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FabricaPedido {

    public Pedido crear(ComandoPedido comandoPedido) {
        Date fecha;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            fecha = sdf.parse(comandoPedido.getFecha());
        } catch (Exception ex) {
            fecha = null;
        }
        return new Pedido(
                comandoPedido.getId(),
                fecha,
                comandoPedido.getDomicilio(),
                comandoPedido.getLstProductos()
        );
    }

}
