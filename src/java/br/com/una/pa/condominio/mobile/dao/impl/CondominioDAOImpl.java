/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.dao.impl;

import br.com.una.pa.condominio.mobile.dao.CondominioDAO;
import br.com.una.pa.condominio.mobile.entidades.Condominio;
import br.ufmg.hc.telessaude.webservices.mobile.exceptions.DAOException;
import java.util.HashMap;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author breno.melo
 */
public class CondominioDAOImpl extends DaoBase<Condominio> implements CondominioDAO {

    public CondominioDAOImpl() {
        super(Condominio.class);
    }

    public Condominio salvarCondominio(Condominio condominio) throws DAOException {
        try {
            session = HibernateUtil.currentSession();
            transaction = session.beginTransaction();
            transaction.begin();
            session.saveOrUpdate(condominio.getEndereco());
            session.saveOrUpdate(condominio);
            transaction.commit();
            return condominio;
        } catch (HibernateException ex) {
            transaction.rollback();
            throw new DAOException(ex.getMessage());
        } finally {
            this.closeSession();
        }
    }

    public Boolean verificarSeJaExiste(Condominio condominio) throws DAOException {
        HashMap<String, String> hash = new HashMap<>();
        hash.put("endereco", "ende");
        List<Object[]> lista = this.consultarPorRestricoes(0, 0, null, hash,
                getProjectList("id", "nome"),
                Restrictions.eq("tipoCondominio.id", condominio.getTipoCondominio().getId()),
                Restrictions.ilike("nome", condominio.getNome()),
                Restrictions.eq("ende.cep", condominio.getEndereco().getCep())
        );
        return lista != null && lista.size() > 0;
    }

}
