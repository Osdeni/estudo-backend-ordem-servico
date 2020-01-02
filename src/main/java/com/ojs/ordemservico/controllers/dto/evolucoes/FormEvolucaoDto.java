package com.ojs.ordemservico.controllers.dto.evolucoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ojs.ordemservico.entities.Evolucao;
import com.ojs.ordemservico.entities.OrdemServico;
import com.ojs.ordemservico.enums.Status;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

public class FormEvolucaoDto {
    private Long id;

    private Date data = new Date();

    private String descricao;

    private Status status;

    public FormEvolucaoDto() {

    }

    public FormEvolucaoDto(Evolucao evolucao) {
        this.id = evolucao.getId();
        this.data = evolucao.getData();
        this.status = evolucao.getStatus();
        this.descricao = evolucao.getDescricao();
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

    @JsonIgnore
    @NotBlank
    public String getDescricaoOuStatus() {

        String string = descricao;

        if (!Objects.isNull(status)) {
            string += status.getIndex();
        }

        return string;
    }

    public Evolucao converter(Long ordemServicoId) {
        Evolucao evolucao = new Evolucao();
        evolucao.setDescricao(this.descricao);
        evolucao.setStatus(this.status);
        evolucao.setOrdemServico(new OrdemServico(ordemServicoId));
        return evolucao;
    }
}
