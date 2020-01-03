package com.ojs.ordemservico.repository;


import com.ojs.ordemservico.entities.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Page<Pessoa> findByNomeContains(String nome, Pageable pageable);
}
