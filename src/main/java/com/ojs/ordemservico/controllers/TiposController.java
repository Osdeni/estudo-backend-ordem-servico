package com.ojs.ordemservico.controllers;

import com.ojs.ordemservico.controllers.dto.tipos.TipoDto;
import com.ojs.ordemservico.entities.Tipo;
import com.ojs.ordemservico.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/tipos")
public class TiposController {

    @Autowired
    private TipoRepository tipoRepository;

    @GetMapping
    public List<TipoDto> all() {
        List<Tipo> tipos = tipoRepository.findAll(Sort.by(Sort.Direction.ASC, "descricao"));
        return TipoDto.converter(tipos);
    }
}
