package com.example.Almacen.services.inventory;

import com.example.Almacen.models.inventory.Inventario;
import com.example.Almacen.models.inventory.RepositoryInventario;
import com.example.Almacen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class InventarioService {
    @Autowired
    RepositoryInventario repositorio;

    @Transactional(readOnly = true)
    public Response<List<Inventario>> getAll(){
        return new Response<>(
                this.repositorio.findAll(),
                false,
                200,
                "Inventarios Encontrados"
        );
    }

    @Transactional(readOnly = true)
    public Response<Inventario>  getOne(Long id){
        return new Response<>(
                this.repositorio.findById(id).get(),
                false,
                200,
                "Inventario Encontrado"
        );
    }

    @Transactional(rollbackFor = SQLException.class)
    public Response<Inventario> insert(Inventario inventario){
        return  new Response<>(
                this.repositorio.saveAndFlush(inventario),
                false,
                200,
                "Inventario Agregado Correctamente"
        );
    }

    @Transactional(rollbackFor = SQLException.class)
    public Response<Inventario> update(Inventario inventario){
        return new Response<>(
                this.repositorio.saveAndFlush(inventario),
                false,
                200,
                "Inventario Actualizado Correctamente"
        );
    }

    @Transactional(rollbackFor = SQLException.class)
    public Response<Boolean> delete(Long id){
        this.repositorio.deleteInventario(id);
        return new Response<>(
                null,
                false,
                200,
                "Inventario borrado Correctamente"
        );
    }

}
