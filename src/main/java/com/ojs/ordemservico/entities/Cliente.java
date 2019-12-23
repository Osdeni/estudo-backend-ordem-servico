package com.ojs.ordemservico.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "C")
public class Cliente extends Pessoa {

    public Cliente() {

    }

    public Cliente(String nome, String email, String telefone, String endereco) {
        super(nome, email, telefone, endereco);
    }
}
