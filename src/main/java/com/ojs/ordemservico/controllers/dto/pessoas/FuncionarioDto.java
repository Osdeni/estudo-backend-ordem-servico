package com.ojs.ordemservico.controllers.dto.pessoas;

import com.ojs.ordemservico.entities.Funcionario;

import java.util.List;
import java.util.stream.Collectors;

public class FuncionarioDto {

    private Long id;
    private String nome;
    private String telefone;
    private String email;

    public FuncionarioDto(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.telefone = funcionario.getTelefone();
        this.email = funcionario.getEmail();
    }

    public static List<FuncionarioDto> converter(List<Funcionario> funcionarios) {
        return funcionarios.stream().map(funcionario -> new FuncionarioDto(funcionario)).collect(Collectors.toList());
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
}