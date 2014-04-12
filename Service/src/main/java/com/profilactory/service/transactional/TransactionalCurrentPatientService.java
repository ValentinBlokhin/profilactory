package com.profilactory.service.transactional;

import com.profilactory.model.dao.Dao;
import com.profilactory.model.entity.CurrentPatient;
import com.profilactory.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ValentinBlokhin on 4/9/2014.
 */
@Service("CurrentPatientService")
public class TransactionalCurrentPatientService implements EntityService<CurrentPatient> {

    @Autowired
    @Qualifier("currentPatientHibernateDao")
    Dao<CurrentPatient> currentPatientDao;

    @Override
    public void saveOrUpdate(CurrentPatient persistence) {
        currentPatientDao.saveOrUpdate(persistence);
    }

    @Override
    public void delete(CurrentPatient persistence) {
        currentPatientDao.delete(persistence);
    }

    @Override
    public CurrentPatient get(Integer id) {
        return currentPatientDao.get(id);
    }

    @Override
    public List<CurrentPatient> getAll(int pageNumber, int pageSize) {
        return currentPatientDao.getAll(pageNumber, pageSize);
    }
}
