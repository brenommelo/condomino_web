/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.controller;

import br.com.una.pa.condominio.mobile.dao.impl.NotificacaoDAOImpl;
import br.com.una.pa.condominio.mobile.entidades.Notificacao;
import br.ufmg.hc.telessaude.webservices.mobile.exceptions.DAOException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author breno
 */
public class NotificacaoController {

    NotificacaoDAOImpl notificacaoDAOImpl = new NotificacaoDAOImpl();

    public NotificacaoController() {
    }

    public List<Notificacao> retornarNotificacoes(Long idCond, Long idUnidade, Long tipo, Boolean solicitacao) {
        try {
            return notificacaoDAOImpl.retornarNotificacoes(idCond, idUnidade, tipo, solicitacao);
        } catch (DAOException ex) {
            Logger.getLogger(NotificacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Notificacao salvarNotificacao(Notificacao notificacao) {
        try {
            if (!validarNotificacao(notificacao)) {
                notificacao.setInclusao(Calendar.getInstance().getTime());
                return notificacaoDAOImpl.saveOrUpdate(notificacao);
            }
        } catch (DAOException ex) {
            Logger.getLogger(NotificacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Boolean validarNotificacao(Notificacao notificacao) {
        try {
            if (notificacao.getCondominio() != null && notificacao.getCondominio().getId() != null
                    && notificacao.getDescricao() != null && !notificacao.getDescricao().isEmpty()) {
                return notificacaoDAOImpl.verificarDuplicidade(notificacao);
            }
        } catch (DAOException ex) {
            Logger.getLogger(NotificacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
