package com.example.Almacen.services.proveedor;

import com.example.Almacen.models.proveedor.Proveedor;
import com.example.Almacen.models.proveedor.RepositoryProveedor;
import com.example.Almacen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProveedorServices {
    @Autowired
    RepositoryProveedor repositoryProveedor;

    @Transactional(readOnly = true)
    public Response<List<Proveedor>> getAll(){
        return new Response<>(
                this.repositoryProveedor.findAll(),
                false,
                200,
                "Proveedores Econtrados"
        );
    }

    @Transactional(readOnly = true)
    public  Response<Proveedor> getOne(Long id){
        return  new Response<>(
                this.repositoryProveedor.findById(id).get(),
                false,
                200,
                "Proveedor Encontrado"

        );
    }

    @Transactional(rollbackFor = SQLException.class)
    public Response<Proveedor> insert(Proveedor proveedor){
        return new Response<>(
                this.repositoryProveedor.saveAndFlush(proveedor),
                false,
                200,
                "Proveedor Insertado correctamente"
        );
    }

    @Transactional(rollbackFor = SQLException.class)
    public Response<Proveedor> update(Proveedor proveedor){
        return new Response<>(
                this.repositoryProveedor.saveAndFlush(proveedor),
                false,
                200,
                "Proveedor Actualizado"
        );
    }

    @Transactional(rollbackFor = SQLException.class)
    public  Response<Boolean> delete(Long id){
        this.repositoryProveedor.deleteProveedor(id);
        return new Response<>(
                null,
                false,
                200,
                "Proveedor Borrado correctamente"
        );
    }
}
