package com.ojs.ordemservico.controllers;

import com.ojs.ordemservico.controllers.dto.tipos.TipoDto;
import com.ojs.ordemservico.entities.Tipo;
import com.ojs.ordemservico.services.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/tipos")
public class TiposController {

    @Autowired
    private TipoService tipoService;

    @GetMapping
    public List<TipoDto> all() {
        List<Tipo> tipos = tipoService.findAll();
        return TipoDto.converter(tipos);
    }
}
