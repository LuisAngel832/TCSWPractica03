package org.uv.tcswpractica03;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Crear SessionFactory a partir de hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Obtener SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Obtener una sesión
    public static Session getSession() {
        return sessionFactory.openSession();
    }

    // Cerrar SessionFactory al terminar la aplicación
    public static void shutdown() {
        getSessionFactory().close();
    }
}
