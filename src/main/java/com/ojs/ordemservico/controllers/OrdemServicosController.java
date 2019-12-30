package com.ojs.ordemservico.controllers;

import com.ojs.ordemservico.controllers.dto.ordemServicos.FormOrdemServicoDto;
import com.ojs.ordemservico.controllers.dto.ordemServicos.OrdemServicoDto;
import com.ojs.ordemservico.entities.OrdemServico;
import com.ojs.ordemservico.enums.Status;
import com.ojs.ordemservico.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
            @RequestParam("status") Optional<Status> status,
            @PageableDefault(sort = {"dataAbertura"}, direction = Sort.Direction.DESC) Pageable paginacao) {

        Page<OrdemServico> ordens;
        if (!status.isPresent()) {
            ordens = ordemServicoRepository.findAll(paginacao);
        } else {
            ordens = ordemServicoRepository.findByStatus(status.get(), paginacao);
        }

        return ResponseEntity.ok().body(OrdemServicoDto.converter(ordens));
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
