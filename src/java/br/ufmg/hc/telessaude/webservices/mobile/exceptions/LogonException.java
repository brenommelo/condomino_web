/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.webservices.mobile.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 *
 * @author igor.santos
 */
public class LogonException extends WebApplicationException {

    /**
     * 
     */
    public LogonException() {
        super();
    }

    /**
     * 
     * @param message 
     */
    public LogonException(String message) {
        super(Response.status(Status.FORBIDDEN).entity(message).build());
    }

    /**
     * 
     * @param message
     * @param throwable 
     */
    public LogonException(String message, Throwable throwable) {
        super(throwable);
    }

}
