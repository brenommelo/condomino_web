/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.webservices.mobile.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author igor.santos
 */
public class ServerException extends WebApplicationException {

    /**
     * 
     * @param message 
     */
    public ServerException(final String message) {
        super(Response.status(Response.Status.BAD_REQUEST).entity(message).build());
    }

}
