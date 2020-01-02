package com.ojs.ordemservico.controllers;

import com.ojs.ordemservico.config.exception.ResourceForbidenException;
import com.ojs.ordemservico.config.exception.ResourceNotFoundException;
import com.ojs.ordemservico.controllers.dto.evolucoes.EvolucaoDto;
import com.ojs.ordemservico.controllers.dto.evolucoes.FormEvolucaoDto;
import com.ojs.ordemservico.entities.Evolucao;
import com.ojs.ordemservico.services.EvolucaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ordem-servicos/{ordemServicoId}/evolucoes")
public class EvolucoesController {

    @Autowired
    private EvolucaoServiceImpl evolucaoService;

    @GetMapping
    public ResponseEntity<List<EvolucaoDto>> all(@PathVariable Long ordemServicoId) {
        List<Evolucao> evolucoes = evolucaoService.findByOrdemServicoId(ordemServicoId);

        return ResponseEntity.ok().body(EvolucaoDto.converter(evolucoes));
    }

    @PostMapping
    public ResponseEntity<FormEvolucaoDto> create(@RequestBody @Valid FormEvolucaoDto form,
                                                  @PathVariable Long ordemServicoId,
                                                  UriComponentsBuilder uriBuilder)
            throws ResourceNotFoundException,
            ResourceForbidenException {

        Evolucao evolucao = form.converter(ordemServicoId);
        evolucaoService.save(evolucao);

        URI uri = uriBuilder.path("/ordem-servicos/{ordemId}/evolucoes").buildAndExpand(ordemServicoId).toUri();

        return ResponseEntity.created(uri).body(new FormEvolucaoDto(evolucao));
    }

}
