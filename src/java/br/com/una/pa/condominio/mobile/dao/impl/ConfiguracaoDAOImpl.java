/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.dao.impl;

import br.com.una.pa.condominio.mobile.dao.ConfiguracaoDAO;
import br.com.una.pa.condominio.mobile.entidades.Condominio;
import br.com.una.pa.condominio.mobile.entidades.Configuracao;
import br.ufmg.hc.telessaude.webservices.mobile.exceptions.DAOException;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author breno.melo
 */
public class ConfiguracaoDAOImpl extends DaoBase<Configuracao> implements ConfiguracaoDAO {

    public ConfiguracaoDAOImpl() {
        super(Configuracao.class);
    }

    public Configuracao retornarConfiguracao(Condominio condominio) throws DAOException {
        List<Configuracao> lista = this.findByRestrictions(0,
                Restrictions.eq("condominio.id", condominio.getId())
        );
        if (lista == null || lista.isEmpty()) {
            return null;
        }
        return lista.get(0);
    }

}
