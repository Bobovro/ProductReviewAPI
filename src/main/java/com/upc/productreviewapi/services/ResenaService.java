package com.upc.productreviewapi.services;

import com.upc.productreviewapi.dtos.EstadisticaResenaDTO;
import com.upc.productreviewapi.dtos.ResenaDTO;
import com.upc.productreviewapi.entities.Producto;
import com.upc.productreviewapi.entities.Resena;
import com.upc.productreviewapi.interfaces.IResenaService;
import com.upc.productreviewapi.repositories.ProductoRepository;
import com.upc.productreviewapi.repositories.ResenaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResenaService implements IResenaService {
    @Autowired
    private ResenaRepository resenaRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResenaDTO saveResena(ResenaDTO dto) {
        Resena entity = modelMapper.map(dto, Resena.class);
        Producto producto =productoRepository.findById(entity.getProducto().getId()).orElseThrow(()-> new RuntimeException("producto no encontrado"));
        entity.setProducto(producto);
        Resena saved = resenaRepository.save(entity);
        return modelMapper.map(saved, ResenaDTO.class);
    }

    @Override
    public List<EstadisticaResenaDTO> statsByProduct() {
        return resenaRepository.statsByProduct();
    }

    @Override
    public List<ResenaDTO> getAllResenas() {
        return resenaRepository.findAll()
                .stream()
                .map(r -> modelMapper.map(r, ResenaDTO.class))
                .toList();
    }
}
