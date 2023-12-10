package com.example.Almacen.models.email;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Email {
    private String emisor;
    private String receptor;
    private String titulo;
    private  String texto;
}
