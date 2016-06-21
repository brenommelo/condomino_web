/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufmg.hc.telessaude.webservices.mobile.servelet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.faces.FactoryFinder;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author breno.melo
 */
@WebServlet("/resource/*")
public class ImageServlet extends HttpServlet implements Servlet {

    static final long serialVersionUID = 1L;

    private FacesContextFactory facesContextFactory;
    FacesContext ctx;
    private Lifecycle lifecycle;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        LifecycleFactory lifecycleFactory = (LifecycleFactory) FactoryFinder
                .getFactory(FactoryFinder.LIFECYCLE_FACTORY);
        facesContextFactory = (FacesContextFactory) FactoryFinder
                .getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
        lifecycle = lifecycleFactory
                .getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ctx = facesContextFactory.getFacesContext(
                getServletContext(), request, response, lifecycle);
        String filename = request.getPathInfo().substring(1);
        File file = new File(getCaminhoRaizArquivos(), filename);
        response.setHeader("Content-Type", getServletContext().getMimeType(filename));
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "inline; filename=\"" + filename + "\"");
        if (file.exists()) {
            Files.copy(file.toPath(), response.getOutputStream());
        }
    }

    protected String getCaminhoRaizArquivos() {
        String os = System.getProperty("os.name").toLowerCase();
        String dir = "/";
        if (os.indexOf("win") >= 0) {
            dir = ctx.getExternalContext().getInitParameter("caminho_externo_win");
        } else {
            dir = ctx.getExternalContext().getInitParameter("caminho_externo_unix");
        }
        return dir;
    }

}
