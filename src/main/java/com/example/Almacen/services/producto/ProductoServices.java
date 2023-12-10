package com.example.Almacen.services.producto;

import com.example.Almacen.models.producto.Producto;
import com.example.Almacen.models.producto.RepositoryProducto;
import com.example.Almacen.models.user.User;
import com.example.Almacen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServices {
    @Autowired
    private RepositoryProducto repositorio;

    @Transactional(readOnly = true)
    public Response<List<Producto>> getAll(){
        return new Response<>(
                this.repositorio.findAll(),
                false,
                200,
                "Productos Encontrados"
        );
    }
    @Transactional(readOnly = true)
    public Response<Producto> getOne(Long id){
        return new Response<>(
                this.repositorio.findById(id).get(),
                false,
                200,
                "Producto Encontrado"
        );
    }

    @Transactional(readOnly = true)
    public Response<Optional<Producto>> getOneByName(String producto){
        return new Response<>(
                this.repositorio.findProductoByNombre(producto),
                false,
                200,
                "Producto Econtrado"
        );
    }
    @Transactional(rollbackFor = SQLException.class)
    public Response<Producto> insert(Producto producto){
        return new Response<>(
                this.repositorio.saveAndFlush(producto),
                false,
                200,
                "Usuario Registrado Correctamente"
        );
    }

    @Transactional(rollbackFor = SQLException.class)
    public  Response<Producto> update(Producto producto){
        return  new Response<>(
                this.repositorio.saveAndFlush(producto),
                false,
                200,
                "Producto Actualizado Correctamente"
        );
    }
    @Transactional(rollbackFor = SQLException.class)
    public Response<Boolean> aumentoProducto(Long id, int cantidad){
        this.repositorio.updateCantidad(id,cantidad);
        return new Response<>(
                null,
                false,
                200,
                "Producto Aumentado Correctamente"
        );
    }

    @Transactional(rollbackFor = SQLException.class)
    public Response<Boolean> delete(Long id){
        this.repositorio.deleteProducto(id);
        return new Response<>(
                null,
                false,
                200,
                "Producto Borrado Correctamente"
        );
    }

}
