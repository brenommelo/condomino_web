/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.resource;

import br.com.una.pa.condominio.mobile.controller.CadastroController;
import br.com.una.pa.condominio.mobile.controller.CondominioController;
import br.com.una.pa.condominio.mobile.controller.PessoaController;
import br.com.una.pa.condominio.mobile.controller.UnidadesController;
import br.com.una.pa.condominio.mobile.entidades.Condominio;
import br.com.una.pa.condominio.mobile.entidades.Pessoa;
import br.com.una.pa.condominio.mobile.entidades.Unidade;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author breno.melo
 */
@Path("/cadastro")
public class CadastroResources extends CustomResources {

    CondominioController condominioController = new CondominioController();
    PessoaController pessoaController = new PessoaController();
    UnidadesController unidadeController = new UnidadesController();
    CadastroController cadastroController = new CadastroController();

    @POST
    @Path("/salvar_condominio")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String cadastroCondominio(final String objetoJson) {
        Condominio condominio = fromJson(objetoJson, Condominio.class);
        Condominio retorno = cadastroController.salvarCadastro(condominio);
           if (retorno == null) {
            return formatarResposta(toJson(retorno, Condominio.class), false, "Erro ao salvar! Tente novamente mais tarde!");
        } else if (retorno.getId() != null && retorno.getId() > 0 && !retorno.getId().equals(0l)) {
            return formatarResposta(toJson(retorno, Condominio.class), false, "Salvo com sucesso!");
        } else if (retorno.getId().equals(0l)) {
            return formatarResposta(toJson(retorno, Condominio.class), true, "Erro ao salvar! Condominio já cadastrado!");
        } else {
            return formatarResposta(toJson(retorno, Condominio.class), true, "Erro ao salvar! Tente novamente mais tarde!");

        }
    }

    @POST
    @Path("/salvar_pessoa")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String cadastroPessoa(final String objetoJson) {
        Pessoa pessoa = fromJson(objetoJson, Pessoa.class);
        Pessoa retorno = pessoaController.salvarPessoa(pessoa);
        if (retorno == null) {
            return formatarResposta(toJson(retorno, Pessoa.class), false, "Erro ao salvar! Tente novamente mais tarde!");
        } else if (retorno.getId() != null && retorno.getId() > 0 && !retorno.getId().equals(0l)) {
            return formatarResposta(toJson(retorno, Pessoa.class), false, "Salvo com sucesso!");
        } else if (retorno.getId().equals(0l)) {
            return formatarResposta(toJson(retorno, Pessoa.class), true, "Erro ao salvar! Pessoa já cadastrada!");
        } else {
            return formatarResposta(toJson(retorno, Pessoa.class), true, "Erro ao salvar! Tente novamente mais tarde!");

        }
    }

    @POST
    @Path("/salvar_unidades")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String cadastroUnidades(final String objetoJson) {
        Unidade[] listaUnidades = fromJson(objetoJson, Unidade[].class);
        String retorno = unidadeController.salvarUnidade(listaUnidades);
         return formatarResposta("", !retorno.contains("Erro"), retorno);
    }

}
