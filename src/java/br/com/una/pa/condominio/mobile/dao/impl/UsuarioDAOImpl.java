/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.dao.impl;

import br.com.una.pa.condominio.mobile.dao.UsuarioDAO;
import br.com.una.pa.condominio.mobile.entidades.Pessoa;
import br.com.una.pa.condominio.mobile.entidades.Usuario;
import br.ufmg.hc.telessaude.webservices.mobile.exceptions.DAOException;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author breno.melo
 */
public class UsuarioDAOImpl extends DaoBase<Usuario> implements UsuarioDAO {

    public UsuarioDAOImpl() {
        super(Usuario.class);
    }

    public Boolean verificarSeJaExiste(Usuario usuario) throws DAOException {
        List<Usuario> lista = this.findByRestrictions(0,
                Restrictions.or(Restrictions.eq("email", usuario.getEmail()),
                        Restrictions.eq("cpf", usuario.getCpf()))
        );

        return lista != null && lista.size() > 0;
    }

    public Usuario login(Usuario usuario) throws DAOException {
        List<Usuario> lista = this.findByRestrictions(0,
                Restrictions.or(
                        Restrictions.eq("email", usuario.getUsuario()) ,
                        Restrictions.eq("cpf", usuario.getUsuario())
                ),
                Restrictions.eq("senha", usuario.getSenha())
        );

        if(lista != null && lista.size() == 1){
            return lista.get(0);
        }
        return null;
    }
    public Usuario retornarUsuario(Usuario usuario) throws DAOException {
        List<Usuario> lista = this.findByRestrictions(0,
                Restrictions.or(
                        Restrictions.eq("email", usuario.getUsuario()) ,
                        Restrictions.eq("cpf", usuario.getUsuario())
                )
        );

        if(lista != null && lista.size() > 0){
            return lista.get(0);
        }
        return null;
    }

}
