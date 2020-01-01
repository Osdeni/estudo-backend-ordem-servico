package com.ojs.ordemservico.controllers.dto.autenticacao;

import com.ojs.ordemservico.entities.Usuario;

import java.util.Collection;

public class UsuarioDto {

    private Long id;
    private String nome;
    private Collection roles;

    public UsuarioDto(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getPessoa().getNome();
        this.roles = usuario.getAuthorities();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Collection getRoles() {
        return roles;
    }
}
