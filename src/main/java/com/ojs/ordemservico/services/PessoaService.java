package com.ojs.ordemservico.services;

import com.ojs.ordemservico.entities.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PessoaService {
    Page<Pessoa> findByNomeContains(String nome, Pageable pageable);

    Page<Pessoa> findAll(Pageable pageable);

    Pessoa save(Pessoa pessoa);
}
