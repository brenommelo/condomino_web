/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.resource;

import br.com.una.pa.condominio.mobile.controller.NotificacaoController;
import br.com.una.pa.condominio.mobile.entidades.Notificacao;
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
@Path("/notificacao")
public class NotificacaoResources extends CustomResources {

    NotificacaoController notificacaoController = new NotificacaoController();

    @POST
    @Path("/retornar_notificacoes")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String retornarNotificacao(final String objetoJson) {
        Notificacao notificacao = fromJson(objetoJson, Notificacao.class);
        List<Notificacao> lista = notificacaoController.retornarNotificacoes(
                notificacao.getCondominio() != null ? notificacao.getCondominio().getId() : null,
                notificacao.getUnidade() != null ? notificacao.getUnidade().getId() : null,
                notificacao.getTipoNotificacao() != null ? notificacao.getTipoNotificacao().getId() : null,
                notificacao.getSolicitacaoSindico() != null ? notificacao.getSolicitacaoSindico() : null
        );

        return formatarResposta(toJson(lista.toArray(), Notificacao[].class));
    }

    @POST
    @Path("/salvar_notificacao")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String salvarNotificacao(final String objetoJson) {
        Notificacao notificacao = fromJson(objetoJson, Notificacao.class);
        Notificacao retorno = notificacaoController.salvarNotificacao(notificacao);
        if(retorno.getId()!=null&&retorno.getId()>0){
            return formatarResposta(toJson(retorno, Notificacao.class), false, "Salvo com sucesso!");
        } else {
            return formatarResposta(toJson(retorno, Notificacao.class), true, "Erro ao salvar! ");
        }
    }

}
