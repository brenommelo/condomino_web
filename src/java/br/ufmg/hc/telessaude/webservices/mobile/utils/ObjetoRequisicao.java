/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.webservices.mobile.utils;

import java.io.Serializable;

/**
 *
 * @author paulo.gomes
 */
public class ObjetoRequisicao implements Serializable {

    private int status;
    private String data;
    private boolean erro;
    private String mensagem;

    public ObjetoRequisicao() {
    }

    public ObjetoRequisicao(int status, String data) {
        this.status = status;
        this.data = data;
        this.erro = false;
        this.mensagem = "";
    }

    public ObjetoRequisicao(int status, String data, boolean erro, String msg) {
        this.status = status;
        this.data = data;
        this.erro = erro;
        this.mensagem = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean getErro() {
        return erro;
    }

    public void setErro(boolean erro) {
        this.erro = erro;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
