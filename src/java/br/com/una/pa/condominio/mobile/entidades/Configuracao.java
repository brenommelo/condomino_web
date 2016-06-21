/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author breno.melo
 */
@Entity
@Table(name = "condominios", schema = "condominio")
public class Configuracao {

    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "timestamp default current_timestamp")
    private Date inclusao;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "timestamp default current_timestamp")
    private Date vencimento;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "pagamento_antecipado", columnDefinition = "timestamp default current_timestamp")
    private Date pagamentoAntecipado;
    private Float juros;
    private Float multa;
    @Column(name = "desconto_pagamento_antecipado")
    private Float descontoPagamentoAntecipado;
    private Boolean rateioDespesas;
    @JoinColumn(name = "id_tipo_condominio")
    @ManyToOne(optional = false)
    private Condominio condominio;
   

    @Transient
    private List<PessoaUnidade> listaPessoaUnidade;

    public Configuracao() {
    }

    public Configuracao(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInclusao() {
        return inclusao;
    }

    public void setInclusao(Date inclusao) {
        this.inclusao = inclusao;
    }

    public Object getClone() {
        try {
            return (super.clone());
        } catch (CloneNotSupportedException e) {
            return (null);
        }
    }


    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public Float getJuros() {
        return juros;
    }

    public void setJuros(Float juros) {
        this.juros = juros;
    }

    public Float getMulta() {
        return multa;
    }

    public void setMulta(Float multa) {
        this.multa = multa;
    }

    public List<PessoaUnidade> getListaPessoaUnidade() {
        return listaPessoaUnidade;
    }

    public void setListaPessoaUnidade(List<PessoaUnidade> listaPessoaUnidade) {
        this.listaPessoaUnidade = listaPessoaUnidade;
    }

    public Date getPagamentoAntecipado() {
        return pagamentoAntecipado;
    }

    public void setPagamentoAntecipado(Date pagamentoAntecipado) {
        this.pagamentoAntecipado = pagamentoAntecipado;
    }

    public Float getDescontoPagamentoAntecipado() {
        return descontoPagamentoAntecipado;
    }

    public void setDescontoPagamentoAntecipado(Float descontoPagamentoAntecipado) {
        this.descontoPagamentoAntecipado = descontoPagamentoAntecipado;
    }

    public Boolean getRateioDespesas() {
        return rateioDespesas;
    }

    public void setRateioDespesas(Boolean rateioDespesas) {
        this.rateioDespesas = rateioDespesas;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

}
