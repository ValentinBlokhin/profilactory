package com.profilactory.model.dao.hibernate;

import com.profilactory.model.entity.DrugDiagnosis;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by ValentinBlokhin on 3/26/2014.
 */
public class DrugDiagnosisHibernateDao extends AbstractHibernateDao<DrugDiagnosis> {
    @Override
    public void saveOrUpdate(DrugDiagnosis persistence) {
        getSession().save(persistence);
    }

    @Override
    public void delete(Long id) {
        Query query = getSession().createQuery("from DrugDiagnosis where id = :drugDiagnosisId");
        query.setLong("drugDiagnosisId", id);
        query.executeUpdate();
    }

    @Override
    public void delete(DrugDiagnosis persistence) {
        getSession().delete(persistence);
    }

    @Override
    public DrugDiagnosis get(Long id) {
        return (DrugDiagnosis) getSession().load(DrugDiagnosis.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DrugDiagnosis> getAll(int pageNumber, int pageSize) {
        Query query = getSession().createQuery("from DrugDiagnosis");
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);
        return query.list();
    }
}
