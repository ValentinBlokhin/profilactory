package com.profilactory.service.transactional;

import com.profilactory.model.dao.Dao;
import com.profilactory.model.dao.hibernate.DrugDiagnosisHibernateDao;
import com.profilactory.model.entity.DrugDiagnosis;
import com.profilactory.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ValentinBlokhin on 4/9/2014.
 */
@Service("DDService")
public class TransactionalDrugDiagnosisService implements EntityService<DrugDiagnosis> {


    @Autowired
    @Qualifier("drugDiagnosisHibernateDao")
    Dao<DrugDiagnosis> dao;

    @Override
    public void saveOrUpdate(DrugDiagnosis persistence) {
        dao.saveOrUpdate(persistence);
    }

    @Override
    public void delete(DrugDiagnosis persistence) {
        dao.delete(persistence);
    }

    @Override
    public DrugDiagnosis get(Integer id) {
        return dao.get(id);
    }

    //TODO getPK
//    public DrugDiagnosis getPK(Integer firstKey, Integer secondKey) {
//        return dao.getPK(firstKey, secondKey);
//    }

    @Override
    public List<DrugDiagnosis> getAll(int pageNumber, int pageSize) {
        return dao.getAll(pageNumber, pageSize);
    }
}
