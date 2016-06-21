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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author breno.melo
 */
@Entity
@Table(name = "perfis", schema = "condominio")
public class Perfil {

    private static final long SerialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "timestamp default current_timestamp")
    private Date inclusao;
    private String descricao;
    private Boolean sindico;
    private Boolean proprietario;
    private Boolean inquilino;
    private Boolean reponsavel;
    private Boolean dependente;
    public Perfil() {
    }

    public Perfil(Long id) {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean isSindico() {
        return sindico;
    }

    public void setSindico(Boolean sindico) {
        this.sindico = sindico;
    }

    public Boolean isProprietario() {
        return proprietario;
    }

    public void setProprietario(Boolean proprietario) {
        this.proprietario = proprietario;
    }

    public Boolean isInquilino() {
        return inquilino;
    }

    public void setInquilino(Boolean inquilino) {
        this.inquilino = inquilino;
    }

    public Boolean isReponsavel() {
        return reponsavel;
    }

    public void setReponsavel(Boolean reponsavel) {
        this.reponsavel = reponsavel;
    }

    public Boolean isDependente() {
        return dependente;
    }

    public void setDependente(Boolean dependente) {
        this.dependente = dependente;
    }

  
}
