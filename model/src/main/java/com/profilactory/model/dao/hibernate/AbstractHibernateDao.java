package com.profilactory.model.dao.hibernate;

import com.profilactory.model.dao.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by ValentinBlokhin on 3/25/2014.
 */
public abstract class AbstractHibernateDao<T> implements Dao<T> {
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
