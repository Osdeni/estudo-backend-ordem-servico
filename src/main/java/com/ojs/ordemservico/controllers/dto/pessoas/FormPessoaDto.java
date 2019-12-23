package com.ojs.ordemservico.controllers.dto.pessoas;

import com.ojs.ordemservico.entities.Pessoa;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class FormPessoaDto {

    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String endereco;

    @NotBlank
    private String telefone;

    public FormPessoaDto() {
    }

    public FormPessoaDto(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.endereco = pessoa.getEndereco();
        this.telefone = pessoa.getTelefone();
    }

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Pessoa converter() {
        return new Pessoa(this.nome, this.email, this.telefone, this.endereco);
    }
}
