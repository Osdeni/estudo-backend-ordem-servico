package com.ojs.ordemservico.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "F")
public class Funcionario extends Pessoa {

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = true)
    private Usuario usuario;

    public Funcionario() {

    }

    public Funcionario(Long id) {
        this.id = id;
    }

    public Funcionario(String nome, String email, String telefone, String endereco) {
        super(nome, email, telefone, endereco);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
