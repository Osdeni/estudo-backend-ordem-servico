package com.ojs.ordemservico.services;

import com.ojs.ordemservico.entities.Marca;
import com.ojs.ordemservico.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public List<Marca> findAll() {
        return marcaRepository.findAll(Sort.by(Sort.Direction.ASC, "descricao"));
    }
}
