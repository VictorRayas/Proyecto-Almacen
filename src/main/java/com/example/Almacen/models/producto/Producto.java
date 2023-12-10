package com.example.Almacen.models.producto;

import com.example.Almacen.models.inventory.Inventario;
import com.example.Almacen.models.proveedor.Proveedor;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "producto")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int cantidad;
    private double precio;
    private String tipo;
    @ManyToOne
    @JoinColumn(name = "inventarioId", nullable = false)
    private Inventario inventario;
    @ManyToOne
    @JoinColumn(name = "proveedorId", nullable = false)
    private Proveedor proveedor;

}
