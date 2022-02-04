package com.ceiba.configuracion;

import com.ceiba.festivos.puerto.repositorio.RepositorioFestivos;
import com.ceiba.festivos.servicio.ServicioActualizarFestivos;
import com.ceiba.festivos.servicio.ServicioCrearFestivos;
import com.ceiba.festivos.servicio.ServicioEliminarFestivos;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.ServicioActualizarPedido;
import com.ceiba.pedido.servicio.ServicioCrearPedido;
import com.ceiba.pedido.servicio.ServicioEliminarPedido;
import com.ceiba.pedidoProducto.puerto.repositorio.RepositorioPedidoProducto;
import com.ceiba.pedidoProducto.servicio.ServicioActualizarPedidoProducto;
import com.ceiba.pedidoProducto.servicio.ServicioCrearPedidoProducto;
import com.ceiba.pedidoProducto.servicio.ServicioEliminarPedidoProducto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.ServicioActualizarProducto;
import com.ceiba.producto.servicio.ServicioCrearProducto;
import com.ceiba.producto.servicio.ServicioEliminarProducto;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearFestivos servicioCrearFestivos(RepositorioFestivos repositorioFestivos) {
        return new ServicioCrearFestivos(repositorioFestivos);
    }

    @Bean
    public ServicioEliminarFestivos servicioEliminarFestivos(RepositorioFestivos repositorioFestivos) {
        return new ServicioEliminarFestivos(repositorioFestivos);
    }

    @Bean
    public ServicioActualizarFestivos servicioActualizarFestivos(RepositorioFestivos repositorioFestivos) {
        return new ServicioActualizarFestivos(repositorioFestivos);
    }

    @Bean
    public ServicioCrearPedido servicioCrearPedido(RepositorioPedido repositorioPedido, RepositorioFestivos repositorioFestivos, RepositorioPedidoProducto repositorioPedidoProducto) {
        return new ServicioCrearPedido(repositorioPedido, repositorioFestivos, repositorioPedidoProducto);
    }

    @Bean
    public ServicioEliminarPedido servicioEliminarPedido(RepositorioPedido repositorioPedido, RepositorioPedidoProducto repositorioPedidoProducto) {
        return new ServicioEliminarPedido(repositorioPedido, repositorioPedidoProducto);
    }

    @Bean
    public ServicioActualizarPedido servicioActualizarPedido(RepositorioPedido repositorioPedido, RepositorioFestivos repositorioFestivos, RepositorioPedidoProducto repositorioPedidoProducto) {
        return new ServicioActualizarPedido(repositorioPedido, repositorioFestivos, repositorioPedidoProducto);
    }

    @Bean
    public ServicioCrearProducto servicioCrearProducto(RepositorioProducto repositorioProducto) {
        return new ServicioCrearProducto(repositorioProducto);
    }

    @Bean
    public ServicioEliminarProducto servicioEliminarProducto(RepositorioProducto repositorioProducto) {
        return new ServicioEliminarProducto(repositorioProducto);
    }

    @Bean
    public ServicioActualizarProducto servicioActualizarProducto(RepositorioProducto repositorioProducto) {
        return new ServicioActualizarProducto(repositorioProducto);
    }

    @Bean
    public ServicioCrearPedidoProducto servicioCrearPedidoProducto(RepositorioPedidoProducto repositorioPedidoProducto) {
        return new ServicioCrearPedidoProducto(repositorioPedidoProducto);
    }

    @Bean
    public ServicioEliminarPedidoProducto servicioEliminarPedidoProducto(RepositorioPedidoProducto repositorioPedidoProducto) {
        return new ServicioEliminarPedidoProducto(repositorioPedidoProducto);
    }

    @Bean
    public ServicioActualizarPedidoProducto servicioActualizarPedidoProducto(RepositorioPedidoProducto repositorioPedidoProducto) {
        return new ServicioActualizarPedidoProducto(repositorioPedidoProducto);
    }
}
