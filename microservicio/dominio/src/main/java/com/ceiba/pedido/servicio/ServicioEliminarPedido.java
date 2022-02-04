package com.ceiba.pedido.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedidoProducto.puerto.repositorio.RepositorioPedidoProducto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ServicioEliminarPedido {

    private static final String FECHA_ERRONEA = "No se puede eliminar el pedido porque ya paso la hora permitida";
    private final RepositorioPedido repositorioPedido;
    private final RepositorioPedidoProducto repositorioPedidoProducto;

    public ServicioEliminarPedido(RepositorioPedido repositorioPedido, RepositorioPedidoProducto repositorioPedidoProducto) {
        this.repositorioPedido = repositorioPedido;
        this.repositorioPedidoProducto = repositorioPedidoProducto;
    }

    public void ejecutar(Long id) {
        DtoPedido pedido = this.repositorioPedido.pedido(id);
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date fecha;
        try {
            fecha = sdf2.parse(pedido.getFecha());
        } catch (Exception ex) {
            throw new ExcepcionDuplicidad(FECHA_ERRONEA);
        }
        validarFecha(fecha);
        this.repositorioPedidoProducto.eliminarPedido(id);
        this.repositorioPedido.eliminar(id);
    }

    private static void validarFecha(Date fecha) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 3);
        if(fecha.before(calendar.getTime())) {
            throw new ExcepcionDuplicidad(FECHA_ERRONEA);
        }
    }
}
