package com.profilactory.model.dao.hibernate;

import com.profilactory.model.entity.DrugDiagnosis;
import com.profilactory.model.entity.DrugDiagnosisPK;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ValentinBlokhin on 3/26/2014.
 */
@Component
public class DrugDiagnosisHibernateDao extends AbstractHibernateDao<DrugDiagnosis> {
    @Override
    public void saveOrUpdate(DrugDiagnosis persistence) {
        getSession().save(persistence);
    }

    @Override
    public void delete(DrugDiagnosis persistence) {
        getSession().delete(persistence);
    }

    @Override
    public DrugDiagnosis get(Integer id) {
        return (DrugDiagnosis) getSession().load(DrugDiagnosis.class, new DrugDiagnosisPK(id, id));
    }

    public DrugDiagnosis getPK(Integer firstKey, Integer secondKey) {
        return (DrugDiagnosis) getSession().load(DrugDiagnosis.class, new DrugDiagnosisPK(firstKey, secondKey));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DrugDiagnosis> getAll(int pageNumber, int pageSize) {
        Query query = getSession().createQuery("from DrugDiagnosis");
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);
        return (List<DrugDiagnosis>) query.list();
    }
}
