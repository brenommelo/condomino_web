/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.controller;

import br.com.una.pa.condominio.mobile.dao.impl.DespesaDAOImpl;
import br.com.una.pa.condominio.mobile.dao.impl.ReceitaDAOImpl;
import br.com.una.pa.condominio.mobile.entidades.Despesa;
import br.com.una.pa.condominio.mobile.entidades.Receita;
import br.com.una.pa.condominio.mobile.entidades.SeparacaoContabil;
import br.ufmg.hc.telessaude.webservices.mobile.exceptions.DAOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author breno
 */
public class FinanceiroController {

    private final ReceitaDAOImpl receitaDAOImpl = new ReceitaDAOImpl();
    private final DespesaDAOImpl despesaDAOImpl = new DespesaDAOImpl();

    public FinanceiroController() {
    }

    public Receita salvarReceita(Receita receita) {
        try {
            if (receita.getRealizacao() == null) {
                receita.setRealizacao(receita.getInclusao());
            }
            if(receita.getSeparacaoContabil()==null||receita.getSeparacaoContabil().getId()==null){
                receita.setSeparacaoContabil(new SeparacaoContabil(1l));
            }
            if (!receitaDAOImpl.validarDuplicidade(receita)) {
                receita.setInclusao(Calendar.getInstance().getTime());
                return receitaDAOImpl.saveOrUpdate(receita);
            }
        } catch (DAOException ex) {
            Logger.getLogger(FinanceiroController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Despesa salvarDespesa(Despesa despesa) {
        try {
            if(despesa.getSeparacaoContabil()==null||despesa.getSeparacaoContabil().getId()==null){
                despesa.setSeparacaoContabil(new SeparacaoContabil(1l));
            }
            if (despesa.getRealizacao() == null) {
                despesa.setRealizacao(Calendar.getInstance().getTime());
            }
            if (!despesaDAOImpl.validarDuplicidade(despesa)) {
                despesa.setInclusao(Calendar.getInstance().getTime());
                return despesaDAOImpl.saveOrUpdate(despesa);
            }
        } catch (DAOException ex) {
            Logger.getLogger(FinanceiroController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Boolean remover(Receita receita) {
        try {
            return receitaDAOImpl.delete(receita.getId());
        } catch (DAOException ex) {
            Logger.getLogger(FinanceiroController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Boolean remover(Despesa despesa) {
        try {
            despesaDAOImpl.delete(despesa.getId());
        } catch (DAOException ex) {
            Logger.getLogger(FinanceiroController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Despesa> consultar(Despesa despesa, Date inicio, Date fim) {
        try {
            if (inicio == null) {
                Calendar calInicio = Calendar.getInstance();
                calInicio.set(Calendar.DAY_OF_MONTH, 1);
                calInicio.set(Calendar.HOUR_OF_DAY, 0);
                calInicio.set(Calendar.MINUTE, 0);
                calInicio.set(Calendar.SECOND, 0);
                inicio = calInicio.getTime();
                Calendar calFim = Calendar.getInstance();
                calFim.setTime(calInicio.getTime());
                calFim.add(Calendar.MONTH, 1);
                fim = calFim.getTime();
            }
            return despesaDAOImpl.listarReceitas(despesa.getCondominio().getId(), inicio, fim);
        } catch (DAOException ex) {
            Logger.getLogger(FinanceiroController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Receita> consultar(Receita receita, Date inicio, Date fim) {
        try {
            if (inicio == null) {
                Calendar calInicio = Calendar.getInstance();
                calInicio.set(Calendar.DAY_OF_MONTH, 1);
                calInicio.set(Calendar.HOUR_OF_DAY, 0);
                calInicio.set(Calendar.MINUTE, 0);
                calInicio.set(Calendar.SECOND, 0);
                inicio = calInicio.getTime();
                Calendar calFim = Calendar.getInstance();
                calFim.setTime(calInicio.getTime());
                calFim.add(Calendar.MONTH, 1);
                fim = calFim.getTime();
            }
            return receitaDAOImpl.listarReceitas(receita.getCondominio().getId(), inicio, fim);
        } catch (DAOException ex) {
            Logger.getLogger(FinanceiroController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
