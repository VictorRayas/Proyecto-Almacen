package com.example.Almacen.controller.inventory.dto;

import com.example.Almacen.models.inventory.Inventario;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class DtoInventario {
    private Long id;
    private String nombre;
    private String ubicacion;

    public Inventario castToInventario(){
        return new Inventario(
                getId(),
                getNombre(),
                getUbicacion(),
                null
        );
    }

}
