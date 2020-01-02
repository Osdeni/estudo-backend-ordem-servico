package com.ojs.ordemservico.controllers.dto.evolucoes;

import com.ojs.ordemservico.entities.Evolucao;
import com.ojs.ordemservico.enums.Status;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class EvolucaoDto {
    private Long id;

    private Date data;

    private String descricao;

    private Status status;

    public EvolucaoDto() {

    }

    public EvolucaoDto(Evolucao evolucao) {
        this.id = evolucao.getId();
        this.data = evolucao.getData();
        this.status = evolucao.getStatus();
        this.descricao = evolucao.getDescricao();
    }

    public static List<EvolucaoDto> converter(List<Evolucao> evolucoes) {
        return evolucoes.stream().map(evolucao -> new EvolucaoDto(evolucao)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
