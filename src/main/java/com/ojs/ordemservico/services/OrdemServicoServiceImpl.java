package com.ojs.ordemservico.services;

import com.ojs.ordemservico.entities.OrdemServico;
import com.ojs.ordemservico.repository.OrdemServicoRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdemServicoServiceImpl implements OrdemServicoService {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Override
    public Page<OrdemServico> findAll(Predicate predicate, Pageable pageable) {
        return ordemServicoRepository.findAll(predicate, pageable);
    }

    @Override
    public Page<OrdemServico> findAll(Pageable pageable) {
        return ordemServicoRepository.findAll(pageable);
    }

    @Override
    public Optional<OrdemServico> findById(Long id) {
        return ordemServicoRepository.findById(id);
    }

    @Override
    public OrdemServico save(OrdemServico ordemServico) {
        return ordemServicoRepository.save(ordemServico);
    }
}
