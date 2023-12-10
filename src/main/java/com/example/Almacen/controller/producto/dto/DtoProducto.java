package com.example.Almacen.controller.producto.dto;

import com.example.Almacen.models.inventory.Inventario;
import com.example.Almacen.models.producto.Producto;
import com.example.Almacen.models.proveedor.Proveedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DtoProducto {
    private Long id;
    private String nombre;
    private int cantidad;
    private double precio;
    private String tipo;
    private Inventario inventario;
    private Proveedor proveedor;


public Producto castToProdcuto(){
        return new Producto(
            getId(),
             getNombre(),
             getCantidad(),
             getPrecio(),
             getTipo(),
             getInventario(),
             getProveedor()
        );
    }

    public int castCantida(){
        return getCantidad();
    };

}