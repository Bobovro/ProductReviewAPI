package com.upc.productreviewapi.controllers;

import com.upc.productreviewapi.dtos.ProductoDTO;
import com.upc.productreviewapi.interfaces.IProductoService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dulanto")

public class ProductoController {
    @Autowired
    private IProductoService productoService;
    @Autowired
    private ModelMapper modelMapper;

    @PreAuthorize("hasAnyRole('Admin','ADMIN','admin')")
    @PostMapping("/trujillo/producto")
    public ResponseEntity<?> productos(@Valid @RequestBody ProductoDTO productoDTO){
        ProductoDTO producto = productoService.saveProducto(productoDTO);
        return ResponseEntity.ok().body(producto);
    }

    @PreAuthorize("hasAnyRole('Admin','ADMIN','admin','USER')")
    @GetMapping("/trujillo/producto")
    public ResponseEntity<List<ProductoDTO>> getProductos(){
        return ResponseEntity.ok(productoService.getAllProductos());
    }
}
