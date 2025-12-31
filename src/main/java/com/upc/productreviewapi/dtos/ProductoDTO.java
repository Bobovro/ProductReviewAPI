package com.upc.productreviewapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductoDTO {
    private Long id;

    private String marca;
    private Double precio;
    private Integer stock;
    private LocalDate fechadeLanzamiento;
}
