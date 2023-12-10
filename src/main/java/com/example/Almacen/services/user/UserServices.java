package com.example.Almacen.services.user;

import com.example.Almacen.models.user.RepositoryUser;
import com.example.Almacen.models.user.User;
import com.example.Almacen.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    RepositoryUser repositoryUser;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Transactional(readOnly = true)
    public Response<List<User>> getAll(){
        return new Response<>(
            this.repositoryUser.findAll(),
            false,
            200,
    "Usuarios Encontrados"
        );
    }
    @Transactional(readOnly = true)
    public Response<User> getOne(Long id){
        return new Response<>(
                this.repositoryUser.findById(id).get(),
                false,
                200,
                "Usuario Econtrado"
        );
    }
    @Transactional(readOnly = true)
    public Response<Optional<User>> getOneByName(String nombre){
        return new Response<>(
                this.repositoryUser.findUserByUsername(nombre),
                false,
                200,
                "Usuario Econtrado"
        );
    }

    @Transactional(rollbackFor = SQLException.class)
    public Response<User> Insert(User user){
        String passwordBCrypt = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordBCrypt);

        if(this.repositoryUser.existsByUsername(user.getUsername())){
            return new Response<>(
                    null,
                    false,
                    201,
                    "El usuario ingresado ya existe en la base de datos"
            );
        }else {
            return new Response<>(
                    this.repositoryUser.saveAndFlush(user),
                    false,
                    200,
                    "Usuario Insertado Correctamente"
            );
        }


    }

    @Transactional(rollbackFor = SQLException.class)
    public Response<Boolean> delete(Long id){
        this.repositoryUser.deleteUser(id);
        return new Response<>(
            null,
                true,
                200,
                "Usuario Eliminado Correctamente"
        );
    }
    @Transactional(rollbackFor = SQLException.class)
    public Response<User> update(User user){
        return new Response<>(
                this.repositoryUser.saveAndFlush(user),
                false,
                200,
                "Usuario modificado Correctamente"
        );

    }



}
