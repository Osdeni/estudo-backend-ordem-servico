package com.ojs.ordemservico.controllers;

import com.ojs.ordemservico.config.exception.ResourceNotFoundException;
import com.ojs.ordemservico.controllers.dto.ordemServicos.FormOrdemServicoDto;
import com.ojs.ordemservico.controllers.dto.ordemServicos.OrdemServicoDto;
import com.ojs.ordemservico.entities.OrdemServico;
import com.ojs.ordemservico.enums.Status;
import com.ojs.ordemservico.repository.OrdemServicoRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/ordem-servicos")
public class OrdemServicosController {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @GetMapping
    public ResponseEntity<Page<OrdemServicoDto>> all(
            @QuerydslPredicate(root = OrdemServico.class) Predicate predicate,
            @PageableDefault(sort = {"dataAbertura"}, direction = Sort.Direction.DESC) Pageable paginacao) {

        Page<OrdemServico> ordens;
        if (predicate != null) {
            ordens = ordemServicoRepository.findAll(predicate, paginacao);
        } else {
            ordens = ordemServicoRepository.findAll(paginacao);
        }

        return ResponseEntity.ok().body(OrdemServicoDto.converter(ordens));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<OrdemServicoDto> get(@PathVariable Long id) throws ResourceNotFoundException
    {
        OrdemServico ordemServico = this.ordemServicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ordem de serviço não encontrada: " + id));

        return ResponseEntity.ok().body(new OrdemServicoDto(ordemServico));
    }

    @PostMapping
    public ResponseEntity<FormOrdemServicoDto> create (@RequestBody @Valid FormOrdemServicoDto form, UriComponentsBuilder uriBuilder) {

        OrdemServico ordemServico = form.converter();
        OrdemServico ordemCriada = ordemServicoRepository.save(ordemServico);

        URI uri = uriBuilder.path("/ordem-servicos/{ordemId}").buildAndExpand(ordemCriada.getId()).toUri();
        return ResponseEntity.created(uri).body(new FormOrdemServicoDto(ordemCriada));
    }

    @GetMapping(path = "/status")
    public ResponseEntity<List<Status>> getListStatus() {
        return ResponseEntity.ok().body(Arrays.asList(Status.values()));
    }
}
