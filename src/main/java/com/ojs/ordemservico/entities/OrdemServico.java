package com.ojs.ordemservico.entities;

import com.ojs.ordemservico.enums.Status;
import com.querydsl.core.annotations.QueryEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ordem_servicos")
@QueryEntity
public class OrdemServico {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataAbertura;

    @Column
    @Temporal(TemporalType.DATE)
    private Date dataFinalizacao;

    @Column
    private String defeito;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_id")
    private Tipo tipo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Pessoa cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "responsavel_id")
    private Funcionario responsavel;

    @Column(name = "status", columnDefinition = "integer default 0")
    @Enumerated(value = EnumType.ORDINAL)
    private Status status;

    public OrdemServico() {
        this.dataFinalizacao = null;
        this.status = Status.ABERTO;
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
}
