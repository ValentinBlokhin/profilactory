package com.profilactory.model.dao.hibernate;

import com.profilactory.model.entity.Patient;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ValentinBlokhin on 3/26/2014.
 */
@Component
public class PatientHibernateDao extends AbstractHibernateDao<Patient> {
    @Override
    public void save(Patient persistence) {
        getSession().save(persistence);
    }

    @Override
    public void update(Patient persistence) {
        getSession().update(persistence);
    }


    @Override
    public void delete(Patient persistence) {
        getSession().delete(persistence);
    }

    @Override
    public Patient get(Integer id) {
        return (Patient) getSession().load(Patient.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Patient> getAll(int pageNumber, int pageSize) {
        Query query = getSession().createQuery("from Patient ");
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);
        return query.list();
    }

    @Override
    public List<Patient> findByCriteria(Object obj) {

        return null;
    }
}
