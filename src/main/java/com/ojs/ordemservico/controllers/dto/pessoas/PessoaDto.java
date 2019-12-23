package com.ojs.ordemservico.controllers.dto.pessoas;

import com.ojs.ordemservico.entities.Pessoa;
import org.springframework.data.domain.Page;

public class PessoaDto {
    private Long id;
    private String nome;
    private String telefone;
    private String email;

    public PessoaDto(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.telefone = pessoa.getTelefone();
        this.email = pessoa.getEmail();
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Page<PessoaDto> converter(Page<Pessoa> pessoas) {
        return pessoas.map(pessoa -> new PessoaDto(pessoa));
    }
}
