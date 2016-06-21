/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.rest.application.config;

import java.util.Set;
import javax.ws.rs.core.Application;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

/**
 *
 * @author breno.melo
 */
@javax.ws.rs.ApplicationPath("condominioservices")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        // following code can be used to customize Jersey 1.x JSON provider:
        resources.add(JacksonJsonProvider.class);
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method. It is automatically
     * populated with all resources defined in the project. If required, comment
     * out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.com.una.pa.condominio.mobile.resource.CadastroResources.class);
        resources.add(br.com.una.pa.condominio.mobile.resource.ConfiguracaoResources.class);
        resources.add(br.com.una.pa.condominio.mobile.resource.FinanceiroResources.class);
        resources.add(br.com.una.pa.condominio.mobile.resource.NotificacaoResources.class);
        resources.add(br.com.una.pa.condominio.mobile.resource.UsuarioResources.class);
    }

}
