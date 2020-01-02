package com.ojs.ordemservico.repository;

import com.ojs.ordemservico.entities.OrdemServico;
import com.ojs.ordemservico.entities.QOrdemServico;
import com.ojs.ordemservico.enums.Status;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long>,
        QuerydslPredicateExecutor<OrdemServico>,
        QuerydslBinderCustomizer<QOrdemServico> {

    public Optional<OrdemServico> findById(Long id);
    public Page<OrdemServico> findByStatus(Status status, Pageable pageable);

    @Override
    default void customize(QuerydslBindings bindings, QOrdemServico ordemServico) {

//        bindings.bind(ordemServico.username).first((path, value) -> path.contains(value));

        bindings.bind(String.class)
                .first((StringPath path, String value) -> path.containsIgnoreCase(value));
        bindings.excluding(ordemServico.responsavel.usuario);
    }
}
