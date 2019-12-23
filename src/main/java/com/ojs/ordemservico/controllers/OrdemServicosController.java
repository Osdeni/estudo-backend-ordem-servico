package com.ojs.ordemservico.controllers;

import com.ojs.ordemservico.controllers.dto.ordemServicos.OrdemServicoDto;
import com.ojs.ordemservico.entities.OrdemServico;
import com.ojs.ordemservico.enums.Status;
import com.ojs.ordemservico.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ordem-servicos")
public class OrdemServicosController {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @GetMapping
    public ResponseEntity<Page<OrdemServicoDto>> all(
            @RequestParam("status") Optional<Status> status,
            @PageableDefault(sort = {"dataAbertura"}) Pageable paginacao) {

        Page<OrdemServico> ordens;
        if (!status.isPresent()) {
            ordens = ordemServicoRepository.findAll(paginacao);
        } else {

            ordens = ordemServicoRepository.findByStatus(status.get(), paginacao);
        }

        return ResponseEntity.ok().body(OrdemServicoDto.converter(ordens));
    }

//    @PostMapping
//    public ResponseEntity<FormPessoaDto> create (@RequestBody @Valid FormPessoaDto form, UriComponentsBuilder uriBuilder) {
//
//        Pessoa pessoa = form.converter();
//
//        // TODO jogar em service?
//        Pessoa pessoaCriada = ordemServicoRepository.save(pessoa);
//
//        URI uri = uriBuilder.path("/pessoas/{pessoaId}").buildAndExpand(pessoaCriada.getId()).toUri();
//        return ResponseEntity.created(uri).body(new FormPessoaDto(pessoaCriada));
//
//    }
}
