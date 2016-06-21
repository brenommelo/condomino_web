/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.dao.impl;

import br.com.una.pa.condominio.mobile.dao.EstadoDAO;
import br.com.una.pa.condominio.mobile.entidades.Estado;

/**
 *
 * @author breno.melo
 */
public class EstadoDAOImpl extends DaoBase<Estado> implements EstadoDAO {

    public EstadoDAOImpl() {
        super(Estado.class);
    }

}
