package com.ojs.ordemservico.controllers.dto.tipos;

import com.ojs.ordemservico.entities.Tipo;

import java.util.List;
import java.util.stream.Collectors;

public class TipoDto {

    private Long id;
    private String descricao;

    public TipoDto(Tipo tipo) {
        this.id = tipo.getId();
        this.descricao = tipo.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static List<TipoDto> converter(List<Tipo> tipos) {
        return tipos.stream().map(TipoDto::new).collect(Collectors.toList());
    }
}
