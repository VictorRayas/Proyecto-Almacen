package com.example.Almacen.models.proveedor;

import com.example.Almacen.models.producto.Producto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "proveedor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String telefono;
    private String correo;
    private String empresa;

    @OneToMany(mappedBy ="proveedor")
    @JsonIgnore
    private List<Producto> producto;

}
