package com.profilactory.model.dao.hibernate;

import com.profilactory.model.entity.Procedure;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ValentinBlokhin on 3/26/2014.
 */
@Component
public class ProcedureHibernateDao extends AbstractHibernateDao<Procedure> {
    @Override
    public void save(Procedure persistence) {
        getSession().save(persistence);
    }

    @Override
    public void update(Procedure persistence) {
        getSession().update(persistence);
    }


    @Override
    public void delete(Procedure persistence) {
        getSession().delete(persistence);
    }

    @Override
    public Procedure get(Integer id) {
        return (Procedure) getSession().load(Procedure.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Procedure> getAll(int pageNumber, int pageSize) {
        Query query = getSession().createQuery("from Procedure ");
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);
        return query.list();
    }

    @Override
    public List<Procedure> findByCriteria(Object obj) {
        return null;
    }
}
