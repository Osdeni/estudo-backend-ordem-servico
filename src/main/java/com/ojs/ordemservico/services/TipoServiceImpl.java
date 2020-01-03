package com.ojs.ordemservico.services;

import com.ojs.ordemservico.entities.Tipo;
import com.ojs.ordemservico.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoServiceImpl implements TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    @Override
    public List<Tipo> findAll() {
        return tipoRepository.findAll(Sort.by(Sort.Direction.ASC, "descricao"));
    }
}
