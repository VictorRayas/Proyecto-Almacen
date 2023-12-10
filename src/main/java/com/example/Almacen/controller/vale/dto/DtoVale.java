package com.example.Almacen.controller.vale.dto;


import com.example.Almacen.models.user.User;
import com.example.Almacen.models.vale.Vale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DtoVale {
    private  Long id;
    private String nombre;
    private String material;
    private String status;
    private Date fechaCreacion;
    private Date fechaMaxima;
    private User user;


    public Vale castToCast(){
        return new Vale(
                getId(),
                getNombre(),
                getMaterial(),
                getStatus(),
                getFechaCreacion(),
                getFechaMaxima(),
                getUser()
        );

    }
}
