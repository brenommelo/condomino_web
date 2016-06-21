/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.resource;

import br.com.una.pa.condominio.mobile.controller.FinanceiroController;
import br.com.una.pa.condominio.mobile.entidades.Despesa;
import br.com.una.pa.condominio.mobile.entidades.Notificacao;
import br.com.una.pa.condominio.mobile.entidades.Receita;
import br.ufmg.hc.telessaude.webservices.mobile.exceptions.LogonException;
import br.ufmg.hc.telessaude.webservices.mobile.utils.GsonUtils;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author breno.melo
 */
@Path("/financeiro")
public class FinanceiroResources extends CustomResources {

    FinanceiroController financeiroController = new FinanceiroController();

    /**
     *
     * @param receitaJson
     * @return
     * @throws LogonException
     */
    @POST
    @Path("/salvar_receita")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String salvarReceita(final String receitaJson) {
        Receita retorno = null;
        Receita receita = fromJson(receitaJson, Receita.class);
        if (receita == null || receita.getCondominio() == null || receita.getCondominio().getId() == null || receita.getValor() == null) {
            return null;
        } else {
            retorno = financeiroController.salvarReceita(receita);
        }
        if (retorno != null && retorno.getId() != null && retorno.getId() > 0) {
            return formatarResposta(toJson(retorno, Receita.class), false, "Salvo com sucesso!");
        } else {
            return formatarResposta(toJson(retorno, Receita.class), true, "Não pode salvar duas receitas iguais!");
        }
    }

    /**
     *
     * @param despesaJson
     * @return
     * @throws LogonException
     */
    @POST
    @Path("/salvar_despesa")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String salvarDespesa(final String despesaJson) {
        Despesa retorno = null;
        Despesa despesa = fromJson(despesaJson, Despesa.class);
        if (despesa == null || despesa.getCondominio() == null
                || despesa.getCondominio().getId() == null || despesa.getValor() == null
                || despesa.getNome() == null || despesa.getNome().isEmpty()) {
            return null;
        } else {
           retorno = financeiroController.salvarDespesa(despesa);
        }
        if (retorno != null && retorno.getId() != null && retorno.getId() > 0) {
            return formatarResposta(toJson(retorno, Despesa.class), false, "Salvo com sucesso!");
        } else {
            return formatarResposta(toJson(retorno, Despesa.class), true, "Não pode salvar duas despesas iguais! ");
        }

    }

    @POST
    @Path("/remover_receita")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String removerReceita(final String objJson) {
        Boolean removeu = false;
        Receita objeto = fromJson(objJson, Receita.class);
        if (objeto == null || objeto.getId() == null) {
//            return null;
            removeu = false;
        } else {
            removeu = financeiroController.remover(objeto);
        }

        return formatarResposta(toJson(removeu, Boolean.class));
    }

    @POST
    @Path("/remover_despesa")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String removerDespesa(final String objJson) {
        Boolean removeu = false;
        Despesa objeto = fromJson(objJson, Despesa.class);
        if (objeto == null || objeto.getId() == null) {
            removeu = false;
        } else {
            removeu = financeiroController.remover(objeto);
        }

        return formatarResposta(toJson(removeu, Boolean.class));
    }

    @POST
    @Path("/consultar_despesa")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String consultarDespesa(final String objJson) {
        List<Despesa> listaRetorno = new ArrayList();
        Despesa objeto = fromJson(objJson, Despesa.class);
        if (objeto == null || objeto.getCondominio() == null || objeto.getCondominio().getId() == null) {
            return null;
        } else {
            listaRetorno = financeiroController.consultar(objeto, objeto.getInclusao(), objeto.getRealizacao());
        }

        return formatarResposta(toJson(listaRetorno.toArray(), Despesa[].class));
    }

    @POST
    @Path("/consultar_receita")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String consultarReceita(final String objJson) {
        List<Receita> listaRetorno = new ArrayList();
        Receita objeto = fromJson(objJson, Receita.class);
        if (objeto == null || objeto.getCondominio() == null || objeto.getCondominio().getId() == null) {
            return null;
        } else {
            listaRetorno = financeiroController.consultar(objeto, objeto.getInclusao(), objeto.getRealizacao());
        }
        return formatarResposta(toJson(listaRetorno.toArray(), Receita[].class));
    }

}
