/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.controller;

import br.com.una.pa.condominio.mobile.dao.impl.PessoaDAOImpl;
import br.com.una.pa.condominio.mobile.dao.impl.PessoaUnidadeDAOImpl;
import br.com.una.pa.condominio.mobile.dao.impl.UsuarioDAOImpl;
import br.com.una.pa.condominio.mobile.entidades.Pessoa;
import br.com.una.pa.condominio.mobile.entidades.Usuario;
import br.ufmg.hc.telessaude.webservices.mobile.exceptions.DAOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author breno
 */
public class UsuarioController {

    UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
    PessoaUnidadeDAOImpl pessoaUnidadeDAOImpl = new PessoaUnidadeDAOImpl();
    PessoaDAOImpl pessoaDAOImpl = new PessoaDAOImpl();

    public UsuarioController() {
    }
    public Usuario salvarUsuario(Usuario usuario){
        try {
            return usuarioDAOImpl.saveOrUpdate(usuario);
        } catch (DAOException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Pessoa login(Usuario usuario) {
        try {
            Pessoa pessoa = pessoaDAOImpl.login(usuario);
            if (pessoa != null && pessoa.getId() != null) {
                pessoa.setUnidade(pessoaUnidadeDAOImpl.listaUnidades(pessoa.getId()));
                return pessoa;
            }

        } catch (DAOException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Usuario retornarUsuario(Usuario user){
        try {
            return usuarioDAOImpl.retornarUsuario(user);
        } catch (DAOException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
