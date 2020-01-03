package com.ojs.ordemservico.repository;

import com.ojs.ordemservico.entities.Evolucao;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvolucaoRepository extends JpaRepository<Evolucao, Long> {
    List<Evolucao> findByOrdemServicoId(Long ordemServicoId, Sort sort);
}
