package com.ojs.ordemservico.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "F")
public class Funcionario extends Pessoa {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
