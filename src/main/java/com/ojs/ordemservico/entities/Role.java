package com.ojs.ordemservico.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "roles")
    private Set<Usuario> usuarios;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }
}
