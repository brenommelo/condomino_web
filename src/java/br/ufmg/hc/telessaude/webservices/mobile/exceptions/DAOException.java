/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.webservices.mobile.exceptions;


public class DAOException extends Exception {

    /**
     * 
     * @param msg
     * @param thrwbl 
     */
    public DAOException(String msg, Throwable thrwbl) {
        super(msg, thrwbl);
        getLogger(msg, thrwbl);
    }

    /**
     * 
     * @param msg 
     */
    public DAOException(String msg) {
        super(msg);
        getLogger(msg, this);
    }

    /**
     * 
     * @param msg
     * @param thrwbl 
     */
    private static void getLogger(String msg, Throwable thrwbl) {
        try {
            if (thrwbl != null) {
            } else {
            }
        } catch (Throwable ex) {
        }
    }
}
