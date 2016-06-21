/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.controller;

import br.com.una.pa.condominio.mobile.dao.impl.CondominioDAOImpl;
import br.com.una.pa.condominio.mobile.entidades.Condominio;
import br.ufmg.hc.telessaude.webservices.mobile.exceptions.DAOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author breno
 */
public class CondominioController {
    CondominioDAOImpl condominioDAOImpl = new CondominioDAOImpl();
    public CondominioController() {
    }

    public Condominio salvarCondominio(Condominio condominio) {
        if (validarDuplicidadeCondominio(condominio)) {
            condominio.setInclusao(Calendar.getInstance().getTime());
            condominio.getEndereco().setInclusao(Calendar.getInstance().getTime());
            try {
               return condominioDAOImpl.salvarCondominio(condominio);
            } catch (DAOException ex) {
                Logger.getLogger(CondominioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            condominio.setId(0l);
            return condominio;
        }

        return null;
    }

    public Boolean validarDuplicidadeCondominio(Condominio condominio) {
        try {
            return !condominioDAOImpl.verificarSeJaExiste(condominio);
        } catch (DAOException ex) {
            Logger.getLogger(CondominioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
