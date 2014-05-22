package com.profilactory.model.dao.hibernate;

import com.profilactory.model.dao.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ValentinBlokhin on 3/25/2014.
 */

@Repository
public abstract class AbstractHibernateDao<T> implements Dao<T> {


    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;


    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
