/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.dao.impl;

import br.com.una.pa.condominio.mobile.dao.ReceitaDAO;
import br.com.una.pa.condominio.mobile.entidades.Receita;
import br.ufmg.hc.telessaude.webservices.mobile.exceptions.DAOException;
import java.util.Date;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author breno.melo
 */
public class ReceitaDAOImpl extends DaoBase<Receita> implements ReceitaDAO {

    public ReceitaDAOImpl() {
        super(Receita.class);
    }

    public Boolean validarDuplicidade(Receita receita) throws DAOException {
        List<Receita> lista = this.findByRestrictions(0,
                Restrictions.eq("realizacao", receita.getRealizacao()),
                receita.getNome()!=null?Restrictions.ilike("nome", receita.getNome()):null,
                receita.getUnidade()!=null?Restrictions.eq("unidade", receita.getUnidade()):null,
                Restrictions.eq("valor", receita.getValor()),
                Restrictions.eq("condominio.id", receita.getCondominio().getId())
        );
        return lista != null && !lista.isEmpty();
    }

    public List<Receita> listarReceitas(Long idCond, Date inicio, Date fim) throws DAOException {

        return this.findByRestrictions(0,
                Restrictions.eq("condominio.id", idCond),
                Restrictions.between("realizacao", inicio, fim)
        );

    }

}
