/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.resource;

import br.com.una.pa.condominio.mobile.controller.ConfiguracaoController;
import br.com.una.pa.condominio.mobile.entidades.Condominio;
import br.com.una.pa.condominio.mobile.entidades.Configuracao;
import br.com.una.pa.condominio.mobile.entidades.Estado;
import br.com.una.pa.condominio.mobile.entidades.Municipio;
import br.com.una.pa.condominio.mobile.entidades.Receita;
import br.com.una.pa.condominio.mobile.entidades.TipoCondominio;
import br.com.una.pa.condominio.mobile.entidades.TipoUnidade;
import br.com.una.pa.condominio.mobile.entidades.Unidade;
import br.ufmg.hc.telessaude.webservices.mobile.utils.GsonUtils;
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
@Path("/configuracao")
public class ConfiguracaoResources extends CustomResources {

    ConfiguracaoController configuracaoController = new ConfiguracaoController();

    @POST
    @Path("/retornar_estados")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String retornarEstados(final String receitaJson) {

        List<Estado> lista = configuracaoController.listarEstados();

        return formatarResposta(toJson(lista.toArray(), Estado[].class));
    }

    @POST
    @Path("/retornar_municipios")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String retornarMunicipios(final String receitaJson) {
        Long idEstado = fromJson(receitaJson, Long.class);
        List<Municipio> lista = configuracaoController.listarMunicipios(idEstado);

        return formatarResposta(toJson(lista, Municipio[].class));
    }

    @POST
    @Path("/retornar_tipo_condominio")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String retornarTipoCondominio(final String objetoJson) {
        List<TipoCondominio> lista = configuracaoController.listarTipoCondominio();

        return formatarResposta(toJson(lista, TipoCondominio[].class));
    }

    @POST
    @Path("/retornar_tipo_unidade")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String retornarTipoUnidade(final String objetoJson) {
        List<TipoUnidade> lista = configuracaoController.listarTipoUnidade();

        return formatarResposta(toJson(lista.toArray(), TipoUnidade[].class));
    }

    @POST
    @Path("/retornar_unidades")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String retornarUnidades(final String objetoJson) {
        Condominio cond = fromJson(objetoJson, Condominio.class);
        List<Unidade> unidades = configuracaoController.listarUnidades(cond);

        return formatarResposta(toJson(unidades.toArray(), Unidade[].class));
    }

    @POST
    @Path("/salvar_configuracoes")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String salvarConfiguracao(final String objetoJson) {
        Configuracao configuracao = GsonUtils.getInstanceWithStringDateAdapter().fromJson(objetoJson, Configuracao.class);
        configuracao = configuracaoController.salvarConfiguracaoCondominio(configuracao);

        if (configuracao != null && configuracao.getId() != null && configuracao.getId() > 0) {
            return formatarResposta(toJson(configuracao, Configuracao.class), false, "Salvo com sucesso!");
        } else {
            return formatarResposta(toJson(configuracao, Configuracao.class), true, "Não foi possivel salvar!Tente novamente mais tarde.");
        }
    }
    @POST
    @Path("/retornar_configuracoes")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String retornarConfiguracao(final String objetoJson) {
        Condominio condominio = GsonUtils.getInstanceWithStringDateAdapter().fromJson(objetoJson, Condominio.class);
        Configuracao configuracao = configuracaoController.retornarConfiguracaoCondominio(condominio);

        if (configuracao != null && configuracao.getId() != null && configuracao.getId() > 0) {
            return formatarResposta(toJson(configuracao, Configuracao.class), false, "Caregado com sucesso!");
        } else {
            return formatarResposta(toJson(configuracao, Configuracao.class), true, "Configuração não localizada para este condomínio!");
        }
    }

}
