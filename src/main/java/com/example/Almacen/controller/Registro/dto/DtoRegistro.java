package com.example.Almacen.controller.Registro.dto;

import com.example.Almacen.models.registro.Registro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DtoRegistro {
    private Long id ;
    private Date fechaPedido;
    private String material;
    private String nombre;

    public Registro castToCast(){
        return  new Registro(
                getId(),
                getFechaPedido(),
                getMaterial(),
                getNombre()
        );
    }
}
