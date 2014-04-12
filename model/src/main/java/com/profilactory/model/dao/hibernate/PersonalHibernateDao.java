package com.profilactory.model.dao.hibernate;

import com.profilactory.model.entity.Personal;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ValentinBlokhin on 3/26/2014.
 */
@Component
public class PersonalHibernateDao extends AbstractHibernateDao<Personal> {
    @Override
    public void saveOrUpdate(Personal persistence) {
        getSession().save(persistence);
    }


    @Override
    public void delete(Personal persistence) {
        getSession().delete(persistence);
    }

    @Override
    public Personal get(Integer id) {
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
