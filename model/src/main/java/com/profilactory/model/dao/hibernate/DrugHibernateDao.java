package com.profilactory.model.dao.hibernate;

import com.profilactory.model.entity.Drug;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ValentinBlokhin on 3/26/2014.
 */
@Component
public class DrugHibernateDao extends AbstractHibernateDao<Drug> {
    @Override
    public void save(Drug persistence) {
        getSession().save(persistence);
    }

    @Override
    public void update(Drug persistence) {
        getSession().update(persistence);
    }


    @Override
    public void delete(Drug persistence) {
        getSession().delete(persistence);
    }

    @Override
    public Drug get(Integer id) {
        return (Drug) getSession().load(Drug.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Drug> getAll(int pageNumber, int pageSize) {
        Query query = getSession().createQuery("from Drug");
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);
        return query.list();
    }

    @Override
    public List<Drug> findByCriteria(Object obj) {
        return null;
    }
}
