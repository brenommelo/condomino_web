/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.controller;

import br.com.una.pa.condominio.mobile.dao.impl.UnidadeDAOImpl;
import br.com.una.pa.condominio.mobile.entidades.Unidade;
import br.ufmg.hc.telessaude.webservices.mobile.exceptions.DAOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author breno
 */
public class UnidadesController {

    UnidadeDAOImpl unidadeDAOImpl = new UnidadeDAOImpl();

    public UnidadesController() {
    }
    
    public Unidade salvarUnidade(Unidade uni){
       Unidade validacao = retornarUnidade(uni);
        if(validacao!=null&&validacao.getId()!=null){
            return validacao;
        }
                try {
                  return  unidadeDAOImpl.saveOrUpdate(uni);
                } catch (DAOException ex) {
                    Logger.getLogger(UnidadesController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        return null;
    }

    public String salvarUnidade(Unidade[] unidade) {
        String retorno = "";
        Boolean erro = false;
        for (Unidade uni : unidade) {
            if (validarDuplicidadeUnidade(uni)) {
                try {
                    unidadeDAOImpl.saveOrUpdate(uni);
                } catch (DAOException ex) {
                    erro = true;
                    Logger.getLogger(UnidadesController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return erro ? "Erro ao salvar! Tente novamente mais tarde." : "Salvo com sucesso!";
    }

    public Boolean validarDuplicidadeUnidade(Unidade unidade) {
        try {
            return !unidadeDAOImpl.verificarSeJaExiste(unidade);
        } catch (DAOException ex) {
            Logger.getLogger(UnidadesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public Unidade retornarUnidade(Unidade unidade) {
        try {
            return unidadeDAOImpl.retornarUnidade(unidade);
        } catch (DAOException ex) {
            Logger.getLogger(UnidadesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
