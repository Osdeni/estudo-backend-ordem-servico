package com.ojs.ordemservico.controllers;

import com.ojs.ordemservico.controllers.dto.pessoas.FormPessoaDto;
import com.ojs.ordemservico.controllers.dto.pessoas.FuncionarioDto;
import com.ojs.ordemservico.controllers.dto.pessoas.PessoaDto;
import com.ojs.ordemservico.entities.Funcionario;
import com.ojs.ordemservico.entities.Pessoa;
import com.ojs.ordemservico.repository.PessoaRepository;
import com.ojs.ordemservico.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/pessoas")
public class PessoasController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<Page<PessoaDto>> all(
            @RequestParam("nome") Optional<String> nome,
            @PageableDefault(sort = {"nome"}) Pageable paginacao) {

        Page<Pessoa> pessoas;
        if (!nome.isPresent()) {
            pessoas = pessoaRepository.findAll(paginacao);
        } else {
            pessoas = pessoaRepository.findByNomeContains(nome.get(), paginacao);
        }

        return ResponseEntity.ok().body(PessoaDto.converter(pessoas));
    }

    @GetMapping(path = "/funcionarios")
    public ResponseEntity<List<FuncionarioDto>> allFuncionarios() {

        List<Funcionario> funcionarios = funcionarioService.findAll();

        return ResponseEntity.ok().body(FuncionarioDto.converter(funcionarios));
    }

    @PostMapping
    public ResponseEntity<FormPessoaDto> create(@RequestBody @Valid FormPessoaDto form, UriComponentsBuilder uriBuilder) {

        Pessoa pessoa = form.converter();

        // TODO jogar em service?
        Pessoa pessoaCriada = pessoaRepository.save(pessoa);

        URI uri = uriBuilder.path("/pessoas/{pessoaId}").buildAndExpand(pessoaCriada.getId()).toUri();
        return ResponseEntity.created(uri).body(new FormPessoaDto(pessoaCriada));

    }
}
