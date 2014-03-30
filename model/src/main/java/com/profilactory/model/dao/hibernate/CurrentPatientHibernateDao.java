package com.profilactory.model.dao.hibernate;

import com.profilactory.model.entity.CurrentPatient;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by ValentinBlokhin on 3/26/2014.
 */
public class CurrentPatientHibernateDao extends AbstractHibernateDao<CurrentPatient> {
    @Override
    public void saveOrUpdate(CurrentPatient persistence) {
        getSession().save(persistence);
    }

    @Override
    public void delete(Integer id) {
        Query query = getSession().createQuery("from CurrentPatient where currentPatientId = :currentPatientId");
        query.setInteger("currentPatientId", id);
        query.executeUpdate();
    }

    @Override
    public void delete(CurrentPatient persistence) {
        getSession().delete(persistence);
    }

    @Override
    public CurrentPatient get(Integer id) {
        return (CurrentPatient) getSession().load(CurrentPatient.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<CurrentPatient> getAll(int pageNumber, int pageSize) {
        Query query = getSession().createQuery("from CurrentPatient");
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);
        return query.list();
    }
}
