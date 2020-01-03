package com.ojs.ordemservico.controllers.dto.ordemServicos;

import javax.validation.constraints.NotNull;

public class PessoaDto {
    @NotNull
    private Long id;

    @NotNull
    private String nome;

    public PessoaDto() {

    }

    public PessoaDto(int id) {
        this.id = new Long(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

