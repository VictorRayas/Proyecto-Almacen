package com.example.Almacen.models.user;


import com.example.Almacen.models.vale.Vale;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String telefono;
    private String direccion;
    private String username;
    private String password;
    private String correo;
    private String rol;
    @OneToMany(mappedBy ="user")  // Debería ser "user", no "usuario"
    @JsonIgnore
    private List<Vale> vales;

}
