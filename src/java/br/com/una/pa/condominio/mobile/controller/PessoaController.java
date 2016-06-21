/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.controller;

import br.com.una.pa.condominio.mobile.dao.impl.PessoaDAOImpl;
import br.com.una.pa.condominio.mobile.entidades.Condominio;
import br.com.una.pa.condominio.mobile.entidades.Pessoa;
import br.com.una.pa.condominio.mobile.entidades.Usuario;
import br.ufmg.hc.telessaude.webservices.mobile.exceptions.DAOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author breno
 */
public class PessoaController {

    PessoaDAOImpl pessoaDAOImpl = new PessoaDAOImpl();
    UsuarioController usuarioController = new UsuarioController();

    public PessoaController() {
    }

    public Pessoa salvarPessoa(Pessoa pessoa) {
        if (validarDuplicidadePessoa(pessoa)) {
            try {
                pessoa.setInclusao(Calendar.getInstance().getTime());
                return pessoaDAOImpl.salvarPessoa(pessoa);
            } catch (DAOException ex) {
                Logger.getLogger(PessoaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            pessoa.setId(0l);
            return pessoa;
        }

        return null;
    }

    public Boolean validarDuplicidadePessoa(Pessoa pessoa) {
        try {
            return !pessoaDAOImpl.verificarSeJaExiste(pessoa);
        } catch (DAOException ex) {
            Logger.getLogger(PessoaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public Usuario retornarUsuario(Usuario usuario){
        return usuarioController.retornarUsuario(usuario);
    }

}
