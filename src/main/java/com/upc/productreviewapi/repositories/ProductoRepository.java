package com.upc.productreviewapi.repositories;

import com.upc.productreviewapi.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
