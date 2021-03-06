package com.profilactory.model.dao.hibernate;

import com.profilactory.model.entity.CurrentProcedure;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ValentinBlokhin on 3/26/2014.
 */
@Component
public class CurrentProcedureHibernateDao extends AbstractHibernateDao<CurrentProcedure> {
    @Override
    public void save(CurrentProcedure persistence) {
        getSession().save(persistence);
    }

    @Override
    public void update(CurrentProcedure persistence) {
        getSession().update(persistence);
    }


    @Override
    public void delete(CurrentProcedure persistence) {
        getSession().delete(persistence);
    }

    @Override
    public CurrentProcedure get(Integer id) {
        return (CurrentProcedure) getSession().load(CurrentProcedure.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CurrentProcedure> getAll(int pageNumber, int pageSize) {
        Query query = getSession().createQuery("from CurrentProcedure");
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);
        return query.list();


    }

    @Override
    public List<CurrentProcedure> findByCriteria(Object obj) {
        return null;
    }
}
