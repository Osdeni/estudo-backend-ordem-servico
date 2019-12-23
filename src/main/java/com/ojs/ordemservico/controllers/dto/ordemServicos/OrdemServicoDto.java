package com.ojs.ordemservico.controllers.dto.ordemServicos;

import com.ojs.ordemservico.entities.*;
import com.ojs.ordemservico.enums.Status;
import org.springframework.data.domain.Page;

import java.util.Date;

public class OrdemServicoDto {
    private Long id;

    private Date dataAbertura;

    private Date dataFinalizacao;

    private String defeito;

    private Tipo tipo;

    private Marca marca;

    private Pessoa cliente;

    private Funcionario responsavel;

    private Status status;

    public OrdemServicoDto(OrdemServico ordemServico) {
        this.id = ordemServico.getId();
        this.dataAbertura = ordemServico.getDataAbertura();
        this.dataFinalizacao = ordemServico.getDataFinalizacao();
        this.defeito = ordemServico.getDefeito();
        this.tipo = ordemServico.getTipo();
        this.marca = ordemServico.getMarca();
        this.cliente = ordemServico.getCliente();
        this.responsavel = ordemServico.getResponsavel();
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

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Funcionario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Funcionario responsavel) {
        this.responsavel = responsavel;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public static Page<OrdemServicoDto> converter(Page<OrdemServico> ordens) {
        return ordens.map(ordemServico -> new OrdemServicoDto(ordemServico));
    }
}
