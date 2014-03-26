package com.profilactory.model.dao.hibernate;

import com.profilactory.model.entity.Permit;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by ValentinBlokhin on 3/26/2014.
 */
public class PermitHibernateDao extends AbstractHibernateDao<Permit> {
    @Override
    public void saveOrUpdate(Permit persistence) {
        getSession().save(persistence);
    }

    @Override
    public void delete(Long id) {
        Query query = getSession().createQuery("from Permit where permitId = :permitId");
        query.setLong("permitId", id);
        query.executeUpdate();
    }

    @Override
    public void delete(Permit persistence) {
        getSession().delete(persistence);
    }

    @Override
    public Permit get(Long id) {
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
}
