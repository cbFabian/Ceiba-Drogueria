package com.ceiba.pedidoProducto.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pedidoProducto.modelo.entidad.PedidoProducto;
import com.ceiba.pedidoProducto.puerto.repositorio.RepositorioPedidoProducto;

public class ServicioActualizarPedidoProducto {

    private static final String EL_FESTIVO_EXISTE_EN_EL_SISTEMA = "El pedido producto existe en el sistema";

    private final RepositorioPedidoProducto repositorioPedidoProducto;

    public ServicioActualizarPedidoProducto(RepositorioPedidoProducto repositorioPedidoProducto) {
        this.repositorioPedidoProducto = repositorioPedidoProducto;
    }

    public void ejecutar(PedidoProducto pedidoProducto) {
        validarExistenciaPrevia(pedidoProducto);
        this.repositorioPedidoProducto.actualizar(pedidoProducto);
    }

    private void validarExistenciaPrevia(PedidoProducto pedidoProducto) {
        boolean existe = this.repositorioPedidoProducto.existePorId(pedidoProducto.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_FESTIVO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
