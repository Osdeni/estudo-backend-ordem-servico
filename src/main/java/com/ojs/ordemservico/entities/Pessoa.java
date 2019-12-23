package com.ojs.ordemservico.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pessoas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue(value = "P")
public class Pessoa {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    @NotNull
    @NotBlank
    @Size(min = 3, max = 100)
    private String nome;

    @Column(length = 100, nullable = false, unique = true)
    @NotNull
    @NotBlank
    @Email
    private String email;

    @Column(length = 15)
    @NotNull
    @NotBlank
    @Size(min = 15, max = 15)
    private String telefone;

    @Column(length = 255)
    private String endereco;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
