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
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataAbertura;

    @JsonFormat(pattern = "dd/MM/yyyy")
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
    private Long responsavel;

    private Status status;

    public FormOrdemServicoDto() {
        this.dataAbertura = null;
        this.dataFinalizacao = null;
    }

    public FormOrdemServicoDto(Date dataAbertura, String defeito, int tipo, int marca,
                               PessoaDto cliente, int responsavel) {
        super();
        this.dataAbertura = dataAbertura;
        this.defeito = defeito;
        this.tipo = new Long(tipo);
        this.marca = new Long(marca);
        this.cliente = cliente;
        this.responsavel = new Long(responsavel);
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

    public void setResponsavel(Long responsavel) {
        this.responsavel = responsavel;
    }

    public Long getTipo() {
        return tipo;
    }

    public Long getMarca() {
        return marca;
    }

    public PessoaDto getCliente() {
        return cliente;
    }

    public Long getResponsavel() {
        return responsavel;
    }

    public Status getStatus() {
        return status;
    }

    public OrdemServico converter() {
        OrdemServico ordem = new OrdemServico();
        ordem.setDataAbertura(this.dataAbertura);
        ordem.setDataFinalizacao(this.dataFinalizacao);
        ordem.setDefeito(this.defeito);

        ordem.setTipo(new Tipo(this.tipo));
        ordem.setMarca(new Marca(this.marca));
        ordem.setCliente(new Pessoa(this.cliente.getId()));
        ordem.setResponsavel(new Funcionario(this.responsavel));

        return ordem;
    }
}
