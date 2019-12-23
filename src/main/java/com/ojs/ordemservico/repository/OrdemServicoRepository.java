package com.ojs.ordemservico.repository;

import com.ojs.ordemservico.entities.OrdemServico;
import com.ojs.ordemservico.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

    public Page<OrdemServico> findByStatus(Status status, Pageable pageable);
}
