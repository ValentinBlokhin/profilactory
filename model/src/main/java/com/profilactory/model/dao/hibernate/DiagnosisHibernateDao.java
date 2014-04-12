package com.profilactory.model.dao.hibernate;

import com.profilactory.model.entity.Diagnosis;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ValentinBlokhin on 3/25/2014.
 */
@Component
public class DiagnosisHibernateDao extends AbstractHibernateDao<Diagnosis> {

    @Override
    public void saveOrUpdate(Diagnosis persistence) {
        getSession().save(persistence);
    }


    @Override
    public void delete(Diagnosis persistence) {
        getSession().delete(persistence);
    }

    @Override
    public Diagnosis get(Integer id) {
        return (Diagnosis) getSession().load(Diagnosis.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Diagnosis> getAll(int pageNumber, int pageSize) {
        Query query = getSession().createQuery("from Diagnosis ");
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);
        return query.list();
    }
}
