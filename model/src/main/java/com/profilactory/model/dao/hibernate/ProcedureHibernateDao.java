package com.profilactory.model.dao.hibernate;

import com.profilactory.model.entity.Procedure;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by ValentinBlokhin on 3/26/2014.
 */
public class ProcedureHibernateDao extends AbstractHibernateDao<Procedure> {
    @Override
    public void saveOrUpdate(Procedure persistence) {
        getSession().save(persistence);
    }

    @Override
    public void delete(Long id) {
        Query query = getSession().createQuery("from Procedure where procedureId = :procedureId");
        query.setLong("procedureId", id);
        query.executeUpdate();
    }

    @Override
    public void delete(Procedure persistence) {
        getSession().delete(persistence);
    }

    @Override
    public Procedure get(Long id) {
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
}
