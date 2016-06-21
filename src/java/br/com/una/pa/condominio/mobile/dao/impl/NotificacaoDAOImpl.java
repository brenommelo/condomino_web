/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.dao.impl;

import br.com.una.pa.condominio.mobile.dao.NotificacaoDAO;
import br.com.una.pa.condominio.mobile.entidades.Notificacao;
import br.ufmg.hc.telessaude.webservices.mobile.exceptions.DAOException;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author breno.melo
 */
public class NotificacaoDAOImpl extends DaoBase<Notificacao> implements NotificacaoDAO {

    public NotificacaoDAOImpl() {
        super(Notificacao.class);
    }

    public List<Notificacao> retornarNotificacoes(Long idCond, Long idUnidade, Long idTipo, Boolean sindico) throws DAOException {
        return this.findByRestrictions(0,
                idCond != null ? Restrictions.eq("condominio.id", idCond) : null,
                idUnidade != null ? Restrictions.eq("unidade.id", idUnidade) : null,
                sindico != null && !sindico ? Restrictions.eq("solicitacaoSindico", sindico) : null,
                idTipo != null ? Restrictions.eq("tipoNotificacao.id", idTipo) : null
        );

    }

    public Boolean verificarDuplicidade(Notificacao notificacao) throws DAOException {
        Integer quantidade = this.countByRestrictions(
                Restrictions.eq("condominio.id", notificacao.getCondominio().getId()),
                Restrictions.eq("descricao", notificacao.getDescricao()),
                Restrictions.eq("tipoNotificacao.id", notificacao.getTipoNotificacao().getId())
        );
        return quantidade != null && quantidade > 0;

    }

}
