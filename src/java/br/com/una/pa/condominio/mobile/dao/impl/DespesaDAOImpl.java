/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.dao.impl;

import br.com.una.pa.condominio.mobile.dao.DespesaDAO;
import br.com.una.pa.condominio.mobile.entidades.Despesa;
import br.ufmg.hc.telessaude.webservices.mobile.exceptions.DAOException;
import java.util.Date;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author breno.melo
 */
public class DespesaDAOImpl extends DaoBase<Despesa> implements DespesaDAO {

    public DespesaDAOImpl() {
        super(Despesa.class);
    }

    public Boolean validarDuplicidade(Despesa objeto) throws DAOException {
        List<Despesa> lista = this.findByRestrictions(0,
                Restrictions.eq("realizacao", objeto.getRealizacao()),
                Restrictions.ilike("nome", objeto.getNome()),
                Restrictions.eq("valor", objeto.getValor()),
                Restrictions.eq("condominio.id", objeto.getCondominio().getId())
        );
        return lista != null && !lista.isEmpty();
    }

    public List<Despesa> listarReceitas(Long idCond, Date inicio, Date fim) throws DAOException {

        return this.findByRestrictions(0,
                Restrictions.eq("condominio.id", idCond),
                Restrictions.between("realizacao", inicio, fim)
        );

    }

}
