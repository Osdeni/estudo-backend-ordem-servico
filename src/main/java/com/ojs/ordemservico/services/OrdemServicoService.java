package com.ojs.ordemservico.services;

import com.ojs.ordemservico.entities.OrdemServico;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface OrdemServicoService {
    Page<OrdemServico> findAll(Predicate predicate, Pageable pageable);

    Page<OrdemServico> findAll(Pageable pageable);

    Optional<OrdemServico> findById(Long id);

    OrdemServico save(OrdemServico ordemServico);
}
