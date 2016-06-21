/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.resource;

import br.com.una.pa.condominio.mobile.controller.UsuarioController;
import br.com.una.pa.condominio.mobile.entidades.Pessoa;
import br.com.una.pa.condominio.mobile.entidades.Usuario;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author breno.melo
 */
@Path("/usuario")
public class UsuarioResources extends CustomResources {

    UsuarioController usuarioController = new UsuarioController();

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String retornarNotificacao(final String objetoJson) {
        Usuario usuario = fromJson(objetoJson, Usuario.class);
        Pessoa retorno = usuarioController.login(usuario);
        if (retorno != null && retorno.getId() != null && retorno.getId() > 0) {
            return formatarResposta(toJson(retorno, Pessoa.class), false, "Sucesso!");
        } else {
            return formatarResposta("", true, "Usuário/senha incorretos! ");
        }
    }

}
