package com.upc.productreviewapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EstadisticaResenaDTO {
        private String productName;
        private Double averageRating;
        private Long reviewsCount;

}
