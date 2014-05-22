package com.profilactory.model.dao.hibernate;

import com.profilactory.model.entity.CurrentPatient;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ValentinBlokhin on 3/26/2014.
 */
@Component
public class CurrentPatientHibernateDao extends AbstractHibernateDao<CurrentPatient> {
    @Override
    public void save(CurrentPatient persistence) {
        getSession().save(persistence);
    }

    @Override
    public void update(CurrentPatient persistence) {
        getSession().update(persistence);
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

    @Override
    public List<CurrentPatient> findByCriteria(Object obj) {
        return null;
    }
}
