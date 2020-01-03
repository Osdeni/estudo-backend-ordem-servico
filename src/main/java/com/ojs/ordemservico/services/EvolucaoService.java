package com.ojs.ordemservico.services;

import com.ojs.ordemservico.config.exception.ResourceForbidenException;
import com.ojs.ordemservico.config.exception.ResourceNotFoundException;
import com.ojs.ordemservico.entities.Evolucao;

import java.util.List;

public interface EvolucaoService {
    Evolucao save(Evolucao evolucao) throws ResourceNotFoundException, ResourceForbidenException;
    List<Evolucao> findByOrdemServicoId(Long ordemServicoId);
}
