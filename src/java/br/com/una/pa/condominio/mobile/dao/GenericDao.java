/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.una.pa.condominio.mobile.dao;

import br.ufmg.hc.telessaude.webservices.mobile.exceptions.DAOException;
import java.util.List;
import java.util.Map;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;

/**
 *
 * @author Igor
 */
public interface GenericDao<T> {

    /**
     *
     * @return @throws DAOException
     */
    public List<T> findAll() throws DAOException;

    /**
     *
     * @param obj
     * @return
     * @throws DAOException
     */
    public T saveOrUpdate(final T obj) throws DAOException;

     public ProjectionList getProjectList(String... properties);
    
    public List<Object[]> consultarPorRestricoes(final int start, final int maxResults, final Order[] order, Map<String, String> alias, final ProjectionList projections, final Criterion... criterions) throws DAOException ;
    /**
     *
     * @param id
     * @return
     * @throws DAOException
     */
    public T findById(final Long id) throws DAOException;

    /**
     *
     * @param obj
     * @return
     * @throws DAOException
     */
    public boolean delete(final T obj) throws DAOException;

    /**
     *
     * @param id
     * @return
     * @throws DAOException
     */
    public boolean delete(final Long id) throws DAOException;

    /**
     *
     * @param key
     * @param value
     * @return
     * @throws DAOException
     */
    public List<T> findByLikeParams(final String key, final String value) throws DAOException;

    /**
     *
     * @param maxResults
     * @param criterions
     * @return
     * @throws DAOException
     */
    public List<T> findByRestrictions(final int maxResults, final Criterion... criterions) throws DAOException;

    /**
     *
     * @param start
     * @param maxResults
     * @param projections
     * @param criterions
     * @return
     * @throws DAOException
     */
    public List<Object> findByRestrictions(final int start, final int maxResults, final ProjectionList projections, final Criterion... criterions) throws DAOException;

    /**
     *
     * @param start
     * @param maxResults
     * @param projections
     * @param criterions
     * @return
     * @throws DAOException
     */
    public List<Object> findByRestrictions(final int start, final int maxResults, final ProjectionList projections, final Order order, final Criterion... criterions) throws DAOException;

    /**
     *
     * @param start
     * @param maxResults
     * @param criterions
     * @return
     * @throws DAOException
     */
    public List<T> findByRestrictions(final int start, final int maxResults, final Criterion... criterions) throws DAOException;

    public Integer countByRestrictions(final Criterion... criterions) throws DAOException;

}
