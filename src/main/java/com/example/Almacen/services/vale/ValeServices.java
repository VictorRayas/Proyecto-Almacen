package com.example.Almacen.services.vale;

import com.example.Almacen.models.user.User;
import com.example.Almacen.models.vale.RepositoryVale;
import com.example.Almacen.models.vale.Vale;
import com.example.Almacen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class ValeServices {
    @Autowired
    private RepositoryVale repositorio;


    @Transactional(readOnly = true)
    public Response<List<Vale>> getAll(){
        return new Response<>(
                this.repositorio.findAll(),
                false,
                200,
                "Vales Encontrados"
        );
    }
    @Transactional(rollbackFor = SQLException.class)
    public Response<Vale> Insert(Vale vale){
        System.out.println("Service");
        System.out.println(vale);
        return new Response<>(
                this.repositorio.saveAndFlush(vale),
                false,
                200,
                "Vale Insertado Correctamente"
        );
    }

    @Transactional(rollbackFor = SQLException.class)
    public Response<Vale> update(Vale vale){
        return new Response<>(
                this.repositorio.saveAndFlush(vale),
                false,
                200,
                "Vale modificado Correctamente"
        );

    }



}
