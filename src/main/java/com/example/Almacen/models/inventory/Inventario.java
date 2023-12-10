package com.example.Almacen.models.inventory;

import com.example.Almacen.models.producto.Producto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

    @Entity
    @Table(name = "inventario")
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public class Inventario {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nombre;
        private String ubicacion;

        @OneToMany(mappedBy ="inventario")
        @JsonIgnore
        private List<Producto> producto;

    }
