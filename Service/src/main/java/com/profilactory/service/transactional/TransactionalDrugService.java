package com.profilactory.service.transactional;

import com.profilactory.model.dao.Dao;
import com.profilactory.model.entity.Drug;
import com.profilactory.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ValentinBlokhin on 4/9/2014.
 */
@Service("DrugService")
public class TransactionalDrugService implements EntityService<Drug> {

    @Autowired
    @Qualifier("drugHibernateDao")
    Dao<Drug> drugDao;

    @Override
    public void save(Drug persistence) {
        drugDao.save(persistence);
    }

    @Override
    public void update(Drug persistence) {
        drugDao.update(persistence);
    }

    @Override
    public void delete(Drug persistence) {
        drugDao.delete(persistence);
    }

    @Override
    public Drug get(Integer id) {
        return drugDao.get(id);
    }

    @Override
    public List<Drug> getAll(int pageNumber, int pageSize) {
        return drugDao.getAll(pageNumber, pageSize);
    }

    @Override
    public List<Drug> findByCriteria(Object obj) {
        return null;
    }
}
