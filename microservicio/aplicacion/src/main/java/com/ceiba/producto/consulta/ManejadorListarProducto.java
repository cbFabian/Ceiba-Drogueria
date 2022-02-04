package com.ceiba.producto.consulta;

import java.util.List;

import com.ceiba.producto.puerto.dao.DaoProducto;
import org.springframework.stereotype.Component;

import com.ceiba.producto.modelo.dto.DtoProducto;

@Component
public class ManejadorListarProducto {

    private final DaoProducto daoProducto;

    public ManejadorListarProducto(DaoProducto daoProducto){
        this.daoProducto = daoProducto;
    }

    public List<DtoProducto> ejecutar(){ return this.daoProducto.listar(); }

    public DtoProducto producto(Long id){ return this.daoProducto.producto(id); }
}
