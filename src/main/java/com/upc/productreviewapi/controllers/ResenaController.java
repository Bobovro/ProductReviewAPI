package com.upc.productreviewapi.controllers;

import com.upc.productreviewapi.dtos.EstadisticaResenaDTO;
import com.upc.productreviewapi.dtos.ResenaDTO;
import com.upc.productreviewapi.interfaces.IResenaService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dulanto")
public class ResenaController {
    @Autowired
    private IResenaService resenaService;
    @Autowired
    private ModelMapper modelMapper;

    @PreAuthorize("hasAnyRole('Admin','ADMIN','admin','USER','user','User')")
    @PostMapping("/trujillo/resena")
    public ResponseEntity<ResenaDTO> resenas(@Valid @RequestBody ResenaDTO resenaDTO){
        ResenaDTO resenaDTO1 = resenaService.saveResena(resenaDTO);
        return ResponseEntity.ok(resenaDTO1);
    }

    @PreAuthorize("hasAnyRole('Admin','ADMIN','admin','USER','user','User')")
    @GetMapping("/trujillo/getresenas")
    public ResponseEntity<List<ResenaDTO>> getResenas(){
        return ResponseEntity.ok(resenaService.getAllResenas());
    }

    @PreAuthorize("hasAnyRole('Admin','ADMIN','admin')")
    @GetMapping("/trujillo/jpls/estadistica")
    public List<EstadisticaResenaDTO>listaEstadisticas(){
        return resenaService.statsByProduct();
    }
}
