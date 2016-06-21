/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.controller;

import br.com.una.pa.condominio.mobile.entidades.Condominio;
import br.com.una.pa.condominio.mobile.entidades.PessoaUnidade;
import br.com.una.pa.condominio.mobile.entidades.Unidade;
import br.com.una.pa.condominio.mobile.entidades.Usuario;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author breno
 */
public class CadastroController {

    CondominioController condominioController = new CondominioController();
    PessoaController pessoaController = new PessoaController();
    UnidadesController unidadesController = new UnidadesController();
    UsuarioController usuarioController = new UsuarioController();

    public CadastroController() {
    }

    public Condominio salvarCadastro(Condominio condominio) {
        Condominio cond = condominioController.salvarCondominio(condominio);
        if (cond != null && cond.getId() != null) {
            List<Unidade> listaPessoaUnidade = condominio.getListaUnidade();
            if (listaPessoaUnidade != null) {
                for (Unidade unidade : listaPessoaUnidade) {
                    unidadesController.salvarUnidade(unidade);
                    salvarUsuario(unidade);
                }
            }
        }
        return cond;
    }
    public void salvarUsuario(Unidade unidade){
        Usuario usuario = new Usuario();
        usuario.setEmail(unidade.getEmailResponsavel());
        usuario.setSenha(unidade.getNome());
        usuario.setInclusao(Calendar.getInstance().getTime());
        usuarioController.salvarUsuario(usuario);
    }

}
