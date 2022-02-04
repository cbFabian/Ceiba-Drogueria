package com.ceiba.pedido.puerto.dao;

import com.ceiba.pedido.modelo.dto.DtoPedido;

import java.util.List;

public interface DaoPedido {

    /**
     * Permite listar pedidos
     * @return los pedidos
     */
    List<DtoPedido> listar();

    /**
     * Permite buscar un pedido por id
     * @return pedido
     */
    DtoPedido pedido(Long id);
}
