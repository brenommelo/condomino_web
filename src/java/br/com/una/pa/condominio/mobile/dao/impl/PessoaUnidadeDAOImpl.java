/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.dao.impl;

import br.com.una.pa.condominio.mobile.dao.PessoaUnidadeDAO;
import br.com.una.pa.condominio.mobile.entidades.Condominio;
import br.com.una.pa.condominio.mobile.entidades.PessoaUnidade;
import br.com.una.pa.condominio.mobile.entidades.Unidade;
import br.ufmg.hc.telessaude.webservices.mobile.exceptions.DAOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author breno.melo
 */
public class PessoaUnidadeDAOImpl extends DaoBase<PessoaUnidade> implements PessoaUnidadeDAO {

    public PessoaUnidadeDAOImpl() {
        super(PessoaUnidade.class);
    }

    public List<Unidade> listaUnidades(Long idPessoa) throws DAOException {
        HashMap<String, String> hash = new HashMap();
        hash.put("unidade", "uni");
        hash.put("uni.condominio", "cond");
        List<Object[]> lista = this.consultarPorRestricoes(0, 0, null, hash,
                getProjectList("uni.id", "uni.nome", "cond.id", "cond.nome"),
                Restrictions.eq("pessoa.id", idPessoa)
        );
        List<Unidade> retorno = null;
        if (lista != null) {
            retorno = new ArrayList();
            for (Object[] obj : lista) {
                Unidade uni = new Unidade(Long.valueOf(obj[0].toString()));
                uni.setNome(obj[1].toString());
                uni.setCondominio(new Condominio(Long.valueOf(obj[2].toString())));
                uni.getCondominio().setNome(obj[3].toString());
                retorno.add(uni);
            }
        }

        return retorno;
    }

}
