package com.ojs.ordemservico.services;

import com.ojs.ordemservico.entities.Pessoa;
import com.ojs.ordemservico.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;


    @Override
    public Page<Pessoa> findByNomeContains(String nome, Pageable pageable) {
        return pessoaRepository.findByNomeContains(nome, pageable);
    }

    @Override
    public Page<Pessoa> findAll(Pageable pageable) {
        return pessoaRepository.findAll(pageable);
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
}
