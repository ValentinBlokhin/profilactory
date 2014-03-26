package com.profilactory.model.dao.hibernate;

import com.profilactory.model.entity.Personal;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by ValentinBlokhin on 3/26/2014.
 */
public class PersonalHibernateDao extends AbstractHibernateDao<Personal> {
    @Override
    public void saveOrUpdate(Personal persistence) {
        getSession().save(persistence);
    }

    @Override
    public void delete(Long id) {
        Query query = getSession().createQuery("from Personal where personalId = :personalId");
        query.setLong("personalId", id);
    }

    @Override
    public void delete(Personal persistence) {
        getSession().delete(persistence);
    }

    @Override
    public Personal get(Long id) {
        return (Personal) getSession().load(Personal.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Personal> getAll(int pageNumber, int pageSize) {
        Query query = getSession().createQuery("from Personal ");
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);
        return query.list();
    }
}
