package com.ojs.ordemservico.controllers.dto.autenticacao;

import com.ojs.ordemservico.entities.Usuario;

public class UsuarioDto {

    private Long id;
    private String nome;

    public UsuarioDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getPessoa().getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
