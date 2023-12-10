package com.example.Almacen.controller.proveedor.dto;

import com.example.Almacen.models.producto.Producto;
import com.example.Almacen.models.proveedor.Proveedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DtoProveedor {
    private Long id;
    private String nombre;
    private String telefono;
    private String correo;
    private String empresa;

    public Proveedor castToProveedor(){
        return new Proveedor(
                getId(),
                getNombre(),
                getTelefono(),
                getCorreo(),
                getEmpresa(),
                null
        );
    }
}
