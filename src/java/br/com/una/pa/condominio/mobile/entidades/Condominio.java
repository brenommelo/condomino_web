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
public class Condominio {

    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "timestamp default current_timestamp")
    private Date inclusao;
    private String nome;
    @JoinColumn(name = "id_tipo_condominio")
    @ManyToOne(optional = false)
    private TipoCondominio tipoCondominio;
    @JoinColumn(name = "id_endereco")
    @ManyToOne(optional = false)
    private Endereco endereco;

    @Transient
    private List<Unidade> listaUnidade;

    public Condominio() {
    }

    public Condominio(Long id) {
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


    public TipoCondominio getTipoCondominio() {
        return tipoCondominio;
    }

    public void setTipoCondominio(TipoCondominio tipoCondominio) {
        this.tipoCondominio = tipoCondominio;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Unidade> getListaUnidade() {
        return listaUnidade;
    }

    public void setListaUnidade(List<Unidade> listaUnidade) {
        this.listaUnidade = listaUnidade;
    }


}
