package com.profilactory.model.dao.hibernate;

import com.profilactory.model.dao.Dao;
import com.profilactory.model.entity.Cabinet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by ValentinBlokhin on 3/25/2014.
 */
public abstract class AbstractHibernateDao implements Dao<Cabinet> {
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
