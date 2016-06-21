/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.dao.impl;

import br.com.una.pa.condominio.mobile.dao.MunicipioDAO;
import br.com.una.pa.condominio.mobile.entidades.Municipio;
import br.ufmg.hc.telessaude.webservices.mobile.exceptions.DAOException;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author breno.melo
 */
public class MunicipioDAOImpl extends DaoBase<Municipio> implements MunicipioDAO {

    public MunicipioDAOImpl() {
        super(Municipio.class);
    }

    public List<Municipio> listarMunicipios(Long id) throws DAOException {
        return findByRestrictions(0, Restrictions.eq("estado.id", id));
    }

}
