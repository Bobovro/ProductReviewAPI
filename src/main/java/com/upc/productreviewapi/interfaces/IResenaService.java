package com.upc.productreviewapi.interfaces;

import com.upc.productreviewapi.dtos.EstadisticaResenaDTO;
import com.upc.productreviewapi.dtos.ResenaDTO;

import java.util.List;

public interface IResenaService {
    public ResenaDTO saveResena(ResenaDTO resenaDTO);
    public List<EstadisticaResenaDTO> statsByProduct();
    List<ResenaDTO> getAllResenas();
}
