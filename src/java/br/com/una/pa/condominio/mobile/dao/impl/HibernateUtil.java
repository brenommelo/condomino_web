package br.com.una.pa.condominio.mobile.dao.impl;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Igor
 */
public class HibernateUtil {

    private static final String LOG = "HIBERNATEUTIL: ";
    private static final ThreadLocal session = new ThreadLocal();
    private static SessionFactory factory;
    private static AnnotationConfiguration cfg;

    static {
        System.out.println(LOG + "Carregando o hibernate.cfg.xml");
        /**
         * Configuracao do hibernate atraves do hibernate.cfg.xml
         */
        cfg = new AnnotationConfiguration();
        String config_file = "src/hibernate.cfg.xml";
        File file = new File(config_file);
        if (!file.exists()) {
//            CustomLogger.getLogger(HibernateUtil.class).error("Arquivo de configuracao nao encontrado" + file.getAbsoluteFile(), new Exception("erro ao inicializar"));
            cfg.configure();
        } else {
            cfg.configure(file.getAbsoluteFile());
        }

        /**
         * Criacao da fabrica de sessoes
         */
        try {
            factory = cfg.buildSessionFactory(); //nao encontrou o hibernate.cfg.xml
        } catch (Exception ex) {
            try {
                throw new Exception(ex.getMessage());
            } catch (Exception ex1) {
                Logger.getLogger(HibernateUtil.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }    }

    public static Session currentSession() throws HibernateException {
        Session s = (Session) session.get();

        if (s != null && s.isOpen()) {
            s.close();
        }

        if (s == null || !s.isOpen()) {
            if (factory != null) {
                s = factory.openSession();
            }
            session.set(s);
        }
        return s;
    }

    public static void closeSession() throws HibernateException {
        Session s = (Session) session.get();
        session.set(null);
        if (s != null) {
            s.close();
        }
    }
}
