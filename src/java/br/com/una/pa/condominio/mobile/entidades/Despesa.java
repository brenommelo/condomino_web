/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.entidades;

import java.util.Date;
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

/**
 *
 * @author breno.melo
 */
@Entity
@Table(name = "despesas", schema = "condominio")
public class Despesa {

    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "timestamp default current_timestamp")
    private Date inclusao;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "timestamp default current_timestamp")
    private Date realizacao;
    private String nome;
    private Float valor;
  
    @JoinColumn(name = "id_previsao_financeira")
    @ManyToOne(optional = true)
    private PrevisaoFinanceira previsaoFinanceira;
    @JoinColumn(name = "id_separacao_contabil")
    @ManyToOne(optional = false)
    private SeparacaoContabil separacaoContabil;
    @JoinColumn(name = "id_condominio")
    @ManyToOne(optional = false)
    private Condominio condominio;

    public Despesa() {
    }

    public Despesa(Long id) {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getRealizacao() {
        return realizacao;
    }

    public void setRealizacao(Date realizacao) {
        this.realizacao = realizacao;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public SeparacaoContabil getSeparacaoContabil() {
        return separacaoContabil;
    }

    public void setSeparacaoContabil(SeparacaoContabil separacaoContabil) {
        this.separacaoContabil = separacaoContabil;
    }

    public Condominio getCondominio() {
        return condominio;
    }

    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    public PrevisaoFinanceira getPrevisaoFinanceira() {
        return previsaoFinanceira;
    }

    public void setPrevisaoFinanceira(PrevisaoFinanceira previsaoFinanceira) {
        this.previsaoFinanceira = previsaoFinanceira;
    }


}
