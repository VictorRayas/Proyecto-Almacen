package com.example.Almacen.models.vale;
import com.example.Almacen.models.user.User;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "vale")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Vale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nombre;
    private String material;
    private String status;
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Temporal(TemporalType.DATE)
    private Date fechaMaxima;
    @ManyToOne
    @JoinColumn(name = "usuarioId", nullable = false)
    private User user;
}
