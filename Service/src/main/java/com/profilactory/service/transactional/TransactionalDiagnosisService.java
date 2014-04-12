package com.profilactory.service.transactional;

import com.profilactory.model.dao.Dao;
import com.profilactory.model.entity.Diagnosis;
import com.profilactory.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ValentinBlokhin on 4/9/2014.
 */
@Service("DiagnosisService")
public class TransactionalDiagnosisService implements EntityService<Diagnosis> {

    @Autowired
    Dao<Diagnosis> diagnosisDao;

    @Override
    public void saveOrUpdate(Diagnosis persistence) {
        diagnosisDao.saveOrUpdate(persistence);
    }

    @Override
    public void delete(Diagnosis persistence) {
        diagnosisDao.delete(persistence);
    }

    @Override
    public Diagnosis get(Integer id) {
        return diagnosisDao.get(id);
    }

    @Override
    public List<Diagnosis> getAll(int pageNumber, int pageSize) {
        return diagnosisDao.getAll(pageNumber, pageSize);
    }
}
