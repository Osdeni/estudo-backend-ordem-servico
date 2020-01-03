package com.ojs.ordemservico.services;

import com.ojs.ordemservico.entities.Funcionario;

import java.util.List;

public interface FuncionarioService {
    List<Funcionario> findAll();
}
