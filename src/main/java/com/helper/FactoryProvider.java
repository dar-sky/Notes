package com.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {
    private static SessionFactory sessionFactory=null;

    public static SessionFactory getFactory()
    {
        if(sessionFactory==null)
        {
            sessionFactory= new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }

    public void destroy()
    {
        if(sessionFactory.isClosed()==false)
        {
            sessionFactory.close();
        }
    }
}
