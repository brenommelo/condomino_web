/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.dao.impl;

import br.com.una.pa.condominio.mobile.dao.PessoaDAO;
import br.com.una.pa.condominio.mobile.entidades.Condominio;
import br.com.una.pa.condominio.mobile.entidades.Perfil;
import br.com.una.pa.condominio.mobile.entidades.Pessoa;
import br.com.una.pa.condominio.mobile.entidades.Unidade;
import br.com.una.pa.condominio.mobile.entidades.Usuario;
import br.ufmg.hc.telessaude.webservices.mobile.exceptions.DAOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author breno.melo
 */
public class PessoaDAOImpl extends DaoBase<Pessoa> implements PessoaDAO {

    public PessoaDAOImpl() {
        super(Pessoa.class);
    }

    public Boolean verificarSeJaExiste(Pessoa pessoa) throws DAOException {
        List<Pessoa> lista = this.findByRestrictions(0,
                Restrictions.eq("nascimento", pessoa.getNascimento()),
                Restrictions.ilike("nome", pessoa.getNome()),
                Restrictions.eq("sexo", pessoa.getSexo())
        );

        return lista != null && lista.size() > 0;
    }

    public Pessoa salvarPessoa(Pessoa pessoa) throws DAOException {
        try {
            session = HibernateUtil.currentSession();
            transaction = session.beginTransaction();
            transaction.begin();
            if (pessoa.getUsuario().getId() == null) {
                session.saveOrUpdate(pessoa.getUsuario());
            }
            session.saveOrUpdate(pessoa);
            transaction.commit();
            return pessoa;
        } catch (HibernateException ex) {
            transaction.rollback();
            throw new DAOException(ex.getMessage());
        } finally {
            this.closeSession();
        }

    }

    public Pessoa login(Usuario usuario) throws DAOException {
        HashMap<String, String> hash = new HashMap();
        hash.put("usuario", "user");
        hash.put("perfil", "perf");
        List<Object[]> lista = this.consultarPorRestricoes(0, 0, null, hash,
                getProjectList("id", "nome", "perf.id", "perf.descricao", "perf.sindico", "perf.reponsavel", "perf.proprietario"),
                Restrictions.or(
                        Restrictions.eq("user.email", usuario.getUsuario()),
                        Restrictions.eq("user.cpf", usuario.getUsuario())
                ),
                Restrictions.eq("user.senha", usuario.getSenha())
        );
//        List<Pessoa> retorno = null;
        if (lista != null) {
//            retorno = new ArrayList();
            for (Object[] obj : lista) {
                Pessoa uni = new Pessoa(Long.valueOf(obj[0].toString()));
                uni.setNome(obj[1].toString());
                uni.setPerfil(new Perfil(Long.valueOf(obj[2].toString())));
                uni.getPerfil().setDescricao(obj[3].toString());
                uni.getPerfil().setSindico((Boolean) obj[4]);
                uni.getPerfil().setReponsavel((Boolean) obj[5]);
                uni.getPerfil().setProprietario((Boolean) obj[6]);
//                retorno.add(uni);
                lista = null;
                return uni;
            }
        }

        return null;
    }

}
