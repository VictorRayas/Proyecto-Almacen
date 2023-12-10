package com.example.Almacen.services.Registro;

import com.example.Almacen.models.proveedor.Proveedor;
import com.example.Almacen.models.registro.Registro;
import com.example.Almacen.models.registro.RepositoryRegistro;
import com.example.Almacen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class RegistroService {
    @Autowired
     RepositoryRegistro repository;

    @Transactional(readOnly = true)
    public Response<List<Registro>> getAll(){
        return new Response<>(
                this.repository.findAll(),
                false,
                200,
                "Registros encontrados"
        );
    }


    @Transactional(rollbackFor = SQLException.class)
    public Response<Registro> insert(Registro registro){
        return new Response<>(
                this.repository.saveAndFlush(registro),
                false,
                200,
                "Registro Insertado correctamente"
        );
    }

}
