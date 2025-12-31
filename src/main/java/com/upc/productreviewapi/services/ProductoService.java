package com.upc.productreviewapi.services;

import com.upc.productreviewapi.dtos.ProductoDTO;
import com.upc.productreviewapi.entities.Producto;
import com.upc.productreviewapi.interfaces.IProductoService;
import com.upc.productreviewapi.repositories.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public ProductoDTO saveProducto(ProductoDTO productoDTO) {
        Producto producto = modelMapper.map(productoDTO, Producto.class);
        Producto newProducto = productoRepository.save(producto);
        return modelMapper.map(newProducto, ProductoDTO.class);
    }

    @Override
    public List<ProductoDTO> getAllProductos() {
        return productoRepository.findAll().stream()
                .map(p -> modelMapper.map(p, ProductoDTO.class))
                .collect(Collectors.toList());
    }
}
