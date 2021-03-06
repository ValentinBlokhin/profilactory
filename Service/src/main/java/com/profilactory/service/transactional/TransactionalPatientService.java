package com.profilactory.service.transactional;

import com.profilactory.model.dao.Dao;
import com.profilactory.model.entity.Patient;
import com.profilactory.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ValentinBlokhin on 4/9/2014.
 */
@Service("PatientService")
public class TransactionalPatientService implements EntityService<Patient> {

    @Autowired
    @Qualifier("patientHibernateDao")
    Dao<Patient> patientDao;

    @Override
    public void save(Patient persistence) {
        patientDao.save(persistence);
    }

    @Override
    public void update(Patient persistence) {
        patientDao.update(persistence);
    }

    @Override
    public void delete(Patient persistence) {
        patientDao.delete(persistence);
    }

    @Override
    public Patient get(Integer id) {
        return patientDao.get(id);
    }

    @Override
    public List<Patient> getAll(int pageNumber, int pageSize) {
        return patientDao.getAll(pageNumber, pageSize);
    }

    @Override
    public List<Patient> findByCriteria(Object obj) {
        return null;
    }
}
