/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.controller;

import br.com.una.pa.condominio.mobile.dao.impl.ConfiguracaoDAOImpl;
import br.com.una.pa.condominio.mobile.dao.impl.EstadoDAOImpl;
import br.com.una.pa.condominio.mobile.dao.impl.MunicipioDAOImpl;
import br.com.una.pa.condominio.mobile.dao.impl.TipoCondominioDAOImpl;
import br.com.una.pa.condominio.mobile.dao.impl.TipoUnidadeDAOImpl;
import br.com.una.pa.condominio.mobile.dao.impl.UnidadeDAOImpl;
import br.com.una.pa.condominio.mobile.entidades.Condominio;
import br.com.una.pa.condominio.mobile.entidades.Configuracao;
import br.com.una.pa.condominio.mobile.entidades.Estado;
import br.com.una.pa.condominio.mobile.entidades.Municipio;
import br.com.una.pa.condominio.mobile.entidades.TipoCondominio;
import br.com.una.pa.condominio.mobile.entidades.TipoUnidade;
import br.com.una.pa.condominio.mobile.entidades.Unidade;
import br.ufmg.hc.telessaude.webservices.mobile.exceptions.DAOException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author breno
 */
public class ConfiguracaoController {

    MunicipioDAOImpl municipioDAOImpl = new MunicipioDAOImpl();
    EstadoDAOImpl estadoDAOImpl = new EstadoDAOImpl();
    TipoCondominioDAOImpl tipoCondominioDAOImpl = new TipoCondominioDAOImpl();
    TipoUnidadeDAOImpl tipoUnidadeDAOImpl = new TipoUnidadeDAOImpl();
    ConfiguracaoDAOImpl configuracaoDAOImpl = new ConfiguracaoDAOImpl();
    UnidadeDAOImpl unidadeDAOImpl = new UnidadeDAOImpl();

    public ConfiguracaoController() {
    }

    public List<Estado> listarEstados() {
        try {
            return estadoDAOImpl.findAll();
        } catch (DAOException ex) {
            Logger.getLogger(ConfiguracaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Municipio> listarMunicipios(Long idEstado) {
        try {
            return municipioDAOImpl.listarMunicipios(idEstado);
        } catch (DAOException ex) {
            Logger.getLogger(ConfiguracaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<TipoCondominio> listarTipoCondominio() {
        try {
            return tipoCondominioDAOImpl.findAll();
        } catch (DAOException ex) {
            Logger.getLogger(ConfiguracaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<TipoUnidade> listarTipoUnidade() {
        try {
            return tipoUnidadeDAOImpl.findAll();
        } catch (DAOException ex) {
            Logger.getLogger(ConfiguracaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Unidade> listarUnidades(Condominio cond) {
        try {
            return unidadeDAOImpl.listaUnidade(cond);
        } catch (DAOException ex) {
            Logger.getLogger(ConfiguracaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Configuracao salvarConfiguracaoCondominio(Configuracao confi) {
        if (confi.getCondominio() != null && confi.getCondominio().getId() != null) {
            try {
                Configuracao validacao = retornarConfiguracaoCondominio(confi.getCondominio());
                if (validacao != null && validacao.getId() != null) {
                    confi.setId(validacao.getId());
                    confi.setInclusao(validacao.getInclusao());
                } else {
                    confi.setInclusao(Calendar.getInstance().getTime());
                }
                return configuracaoDAOImpl.saveOrUpdate(confi);
            } catch (DAOException ex) {
                Logger.getLogger(ConfiguracaoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public Configuracao retornarConfiguracaoCondominio(Condominio cond) {
        try {
            return configuracaoDAOImpl.retornarConfiguracao(cond);
        } catch (DAOException ex) {
            Logger.getLogger(ConfiguracaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
