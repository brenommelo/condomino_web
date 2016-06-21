/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.dao.impl;

import br.com.una.pa.condominio.mobile.dao.UnidadeDAO;
import br.com.una.pa.condominio.mobile.entidades.Condominio;
import br.com.una.pa.condominio.mobile.entidades.Unidade;
import br.ufmg.hc.telessaude.webservices.mobile.exceptions.DAOException;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author breno.melo
 */
public class UnidadeDAOImpl extends DaoBase<Unidade> implements UnidadeDAO {

    public UnidadeDAOImpl() {
        super(Unidade.class);
    }

    public Boolean verificarSeJaExiste(Unidade unidade) throws DAOException {
        List<Unidade> lista = this.findByRestrictions(0,
                Restrictions.eq("condominio.id", unidade.getCondominio().getId()),
                Restrictions.ilike("nome", unidade.getNome())
        );
        return lista != null && lista.size() > 0;
    }

    public Unidade retornarUnidade(Unidade unidade) throws DAOException {
        List<Unidade> lista = this.findByRestrictions(0,
                Restrictions.eq("condominio.id", unidade.getCondominio().getId()),
                Restrictions.ilike("nome", unidade.getNome())
        );
        return lista != null && lista.size() > 0 ? lista.get(0) : null;
    }

    public List<Unidade> listaUnidade(Condominio cond) throws DAOException {
        List<Unidade> lista = this.findByRestrictions(0,
                Restrictions.eq("condominio.id", cond.getId())
        );
        return lista;
    }

}
