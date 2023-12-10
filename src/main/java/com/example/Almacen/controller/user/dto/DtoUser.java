package com.example.Almacen.controller.user.dto;

import com.example.Almacen.models.user.User;
import com.example.Almacen.models.vale.Vale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DtoUser {
    private Long id;
    private String nombre;
    private String telefono;
    private String direccion;
    private String username;
    private String password;
    private String correo;
    private String rol;
    private Vale vale;

    public User castToCast(){
        return new User(
                getId(),
                getNombre(),
                getTelefono(),
                getDireccion(),
                getUsername(),
                getPassword(),
                getCorreo(),
                getRol(),
                null
        );
    }
}
