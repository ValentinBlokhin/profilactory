package com.profilactory.model.dao.hibernate;

import com.profilactory.model.entity.Permit;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ValentinBlokhin on 3/26/2014.
 */
@Component
public class PermitHibernateDao extends AbstractHibernateDao<Permit> {
    @Override
    public void save(Permit persistence) {
        getSession().save(persistence);
    }

    @Override
    public void update(Permit persistence) {
        getSession().update(persistence);
    }


    @Override
    public void delete(Permit persistence) {
        getSession().delete(persistence);
    }

    @Override
    public Permit get(Integer id) {
        return (Permit) getSession().load(Permit.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Permit> getAll(int pageNumber, int pageSize) {
        Query query = getSession().createQuery("from Permit");
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);
        return query.list();
    }

    @Override
    public List<Permit> findByCriteria(Object obj) {
        return null;
    }
}
