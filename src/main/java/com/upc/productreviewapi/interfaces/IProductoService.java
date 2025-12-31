package com.upc.productreviewapi.interfaces;

import com.upc.productreviewapi.dtos.ProductoDTO;

import java.util.List;

public interface IProductoService {
    public ProductoDTO saveProducto(ProductoDTO productoDTO);
    List<ProductoDTO> getAllProductos();
}
