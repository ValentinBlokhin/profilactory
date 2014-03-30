package com.profilactory.model.dao.hibernate;

import com.profilactory.model.entity.Patient;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by ValentinBlokhin on 3/26/2014.
 */
public class PatientHibernateDao extends AbstractHibernateDao<Patient> {
    @Override
    public void saveOrUpdate(Patient persistence) {
        getSession().save(persistence);
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
}
