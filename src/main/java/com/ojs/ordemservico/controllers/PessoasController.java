package com.ojs.ordemservico.controllers;

import com.ojs.ordemservico.controllers.dto.pessoas.FormPessoaDto;
import com.ojs.ordemservico.controllers.dto.pessoas.PessoaDto;
import com.ojs.ordemservico.entities.Pessoa;
import com.ojs.ordemservico.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController()
@RequestMapping("/pessoas")
public class PessoasController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public ResponseEntity<Page<PessoaDto>> all(
            @RequestParam("nome") Optional<String> nome,
            @PageableDefault(sort = {"nome"}) Pageable paginacao) {

        Page<Pessoa> pessoas;
        if (!nome.isPresent()) {
            pessoas = pessoaRepository.findAll(paginacao);
        } else {
            System.out.println();
            pessoas = pessoaRepository.findByNomeContains(nome.get(), paginacao);
        }

        return ResponseEntity.ok().body(PessoaDto.converter(pessoas));
    }

    @PostMapping
    public ResponseEntity<FormPessoaDto> create (@RequestBody @Valid FormPessoaDto form, UriComponentsBuilder uriBuilder) {

        Pessoa pessoa = form.converter();

        // TODO jogar em service?
        Pessoa pessoaCriada = pessoaRepository.save(pessoa);

        URI uri = uriBuilder.path("/pessoas/{pessoaId}").buildAndExpand(pessoaCriada.getId()).toUri();
        return ResponseEntity.created(uri).body(new FormPessoaDto(pessoaCriada));

    }
}
