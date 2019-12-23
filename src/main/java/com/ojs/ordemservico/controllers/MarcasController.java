package com.ojs.ordemservico.controllers;

import com.ojs.ordemservico.controllers.dto.marcas.MarcaDto;
import com.ojs.ordemservico.entities.Marca;
import com.ojs.ordemservico.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/marcas")
public class MarcasController {

    @Autowired
    private MarcaRepository marcaRepository;

    @GetMapping
    public List<MarcaDto> all() {
        List<Marca> marcas = marcaRepository.findAll(Sort.by(Sort.Direction.ASC, "descricao"));
        return MarcaDto.converter(marcas);
    }
}
