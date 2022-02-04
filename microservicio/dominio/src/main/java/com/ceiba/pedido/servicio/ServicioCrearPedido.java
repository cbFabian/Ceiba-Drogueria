package com.ceiba.pedido.servicio;

import com.ceiba.festivos.puerto.repositorio.RepositorioFestivos;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pedidoProducto.modelo.entidad.PedidoProducto;
import com.ceiba.pedidoProducto.puerto.repositorio.RepositorioPedidoProducto;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class ServicioCrearPedido {

    private static final String EL_PEDIDO_YA_EXISTE_EN_EL_SISTEMA = "El pedido ya existe en el sistema";
    private static final String FECHA_ERRONEA = "La fecha debe ser superior a la fecha actual";
    private static final String EL_PEDIDO_ES_SABADO_DOMINGO = "No se realiza atención los dias sabados ni domingos";
    public static BigDecimal precioDomicilio = new BigDecimal(5000);

    private final RepositorioFestivos repositorioFestivos;
    private final RepositorioPedido repositorioPedido;
    private final RepositorioPedidoProducto repositorioPedidoProducto;

    public ServicioCrearPedido(RepositorioPedido repositorioPedido, RepositorioFestivos repositorioFestivos, RepositorioPedidoProducto repositorioPedidoProducto) {
        this.repositorioPedido = repositorioPedido;
        this.repositorioFestivos = repositorioFestivos;
        this.repositorioPedidoProducto = repositorioPedidoProducto;
    }

    public Long ejecutar(Pedido pedido) {
        validarExistenciaPrevia(pedido);
        validarFecha(pedido.getFecha());
        validarSabadoDomingo(pedido);
        validarFestivo(repositorioFestivos, precioDomicilio, pedido);
        Long idPedido = this.repositorioPedido.crear(pedido);

        for(PedidoProducto prod : pedido.getLstProductos()) {
            prod.setIdPedido(idPedido);
            this.repositorioPedidoProducto.crear(prod);
        }
        return idPedido;
    }

    public static void validarFecha(Date fecha) {
        if(fecha.before(new Date())) {
            throw new ExcepcionDuplicidad(FECHA_ERRONEA);
        }
    }

    private void validarExistenciaPrevia(Pedido pedido) {
        boolean existe = this.repositorioPedido.existe(pedido.getFecha());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_PEDIDO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    public static void validarSabadoDomingo(Pedido pedido) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(pedido.getFecha());

        int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);

        if(diaSemana == 1 || diaSemana == 7) {
            throw new ExcepcionDuplicidad(EL_PEDIDO_ES_SABADO_DOMINGO);
        }
    }

    public static void validarFestivo(RepositorioFestivos repositorioFestivos, BigDecimal precioDomicilio, Pedido pedido) {
        boolean existe = repositorioFestivos.existe(pedido.getFecha());
        if(existe) {
            pedido.setDomicilio(precioDomicilio.multiply(new BigDecimal(2)));
        } else {
            pedido.setDomicilio(precioDomicilio);
        }
    }
}
