package com.ceiba.pedido.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.festivos.puerto.repositorio.RepositorioFestivos;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedidoProducto.modelo.entidad.PedidoProducto;
import com.ceiba.pedidoProducto.puerto.repositorio.RepositorioPedidoProducto;

public class ServicioActualizarPedido {

    private static final String EL_FESTIVO_NO_EXISTE_EN_EL_SISTEMA = "El pedido ya existe en el sistema";

    private final RepositorioPedido repositorioPedido;
    private final RepositorioFestivos repositorioFestivos;
    private final RepositorioPedidoProducto repositorioPedidoProducto;

    public ServicioActualizarPedido(RepositorioPedido repositorioPedido, RepositorioFestivos repositorioFestivos, RepositorioPedidoProducto repositorioPedidoProducto) {
        this.repositorioPedido = repositorioPedido;
        this.repositorioFestivos = repositorioFestivos;
        this.repositorioPedidoProducto = repositorioPedidoProducto;
    }

    public void ejecutar(Pedido pedido) {
        validarExistenciaPrevia(pedido);
        ServicioCrearPedido.validarFecha(pedido.getFecha());
        ServicioCrearPedido.validarSabadoDomingo(pedido);
        ServicioCrearPedido.validarFestivo(repositorioFestivos, ServicioCrearPedido.precioDomicilio, pedido);
        this.repositorioPedido.actualizar(pedido);

        this.repositorioPedidoProducto.eliminarPedido(pedido.getId());
        for(PedidoProducto prod : pedido.getLstProductos()) {
            prod.setIdPedido(pedido.getId());
            this.repositorioPedidoProducto.crear(prod);
        }
    }

    private void validarExistenciaPrevia(Pedido pedido) {
        boolean existe = this.repositorioPedido.existePorId(pedido.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_FESTIVO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
