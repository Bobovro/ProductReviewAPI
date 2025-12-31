package com.upc.productreviewapi.repositories;

import com.upc.productreviewapi.dtos.EstadisticaResenaDTO;
import com.upc.productreviewapi.entities.Resena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ResenaRepository extends JpaRepository<Resena, Long> {

    @Query("""
        SELECT new com.upc.productreviewapi.dtos.EstadisticaResenaDTO(
            p.marca,
            AVG(r.calificacion),
            COUNT(r)
        )
        FROM Resena r
        JOIN r.producto p
        GROUP BY p.marca
        ORDER BY p.marca
    """)
    List<EstadisticaResenaDTO> statsByProduct();
}