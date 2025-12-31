package com.upc.productreviewapi.dtos;

import com.upc.productreviewapi.entities.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ResenaDTO {
    private Long id;
    private String nombre;
    private Integer calificacion;
    private String comentario;
    private LocalDate fechaResena;
    private Producto producto;
}
