package com.ojs.ordemservico.services;

import com.ojs.ordemservico.entities.Funcionario;
import com.ojs.ordemservico.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }
}
