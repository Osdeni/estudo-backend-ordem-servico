package com.ojs.ordemservico.controllers.dto.ordemServicos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ojs.ordemservico.entities.*;
import com.ojs.ordemservico.enums.Status;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class FormOrdemServicoDto {
    private Long id;

    @NotNull
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataAbertura;

    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataFinalizacao;

    @NotBlank
    private String defeito;

    @NotNull
    private Long tipo;

    @NotNull
    private Long marca;

    @NotNull
    private PessoaDto cliente;

    @NotNull
    private PessoaDto responsavel;

    private Status status;

    public FormOrdemServicoDto() {
        this.dataAbertura = null;
        this.dataFinalizacao = null;
    }

    public FormOrdemServicoDto(OrdemServico ordemServico) {
        this.id = ordemServico.getId();
        this.dataAbertura = ordemServico.getDataAbertura();
        this.dataFinalizacao = ordemServico.getDataFinalizacao();
        this.defeito = ordemServico.getDefeito();
        this.tipo = ordemServico.getTipo().getId();
        this.status = ordemServico.getStatus();
    }

    public Long getId() {
        return id;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(Date dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public void setTipo(Long tipo) {
        this.tipo = tipo;
    }

    public void setMarca(Long marca) {
        this.marca = marca;
    }

    public void setCliente(PessoaDto cliente) {
        this.cliente = cliente;
    }

    public void setResponsavel(PessoaDto responsavel) {
        this.responsavel = responsavel;
    }

    public OrdemServico converter() {
        OrdemServico ordem = new OrdemServico();
        ordem.setDataAbertura(this.dataAbertura);
        ordem.setDataFinalizacao(this.dataFinalizacao);
        ordem.setDefeito(this.defeito);

        ordem.setTipo(new Tipo(this.tipo));
        ordem.setMarca(new Marca(this.marca));
        ordem.setCliente(new Cliente(this.cliente.getId()));
        ordem.setResponsavel(new Funcionario(this.responsavel.getId()));

        return ordem;
    }
}
