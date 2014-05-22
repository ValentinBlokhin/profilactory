package com.profilactory.service.transactional;

import com.profilactory.model.dao.Dao;
import com.profilactory.model.entity.Personal;
import com.profilactory.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ValentinBlokhin on 4/9/2014.
 */
@Service("PersonalService")
public class TransactionalPersonalService implements EntityService<Personal> {
    @Autowired
    @Qualifier("personalHibernateDao")
    Dao<Personal> personalDao;

    @Override
    public void save(Personal persistence) {
        personalDao.save(persistence);
    }

    @Override
    public void update(Personal persistence) {
        personalDao.update(persistence);
    }

    @Override
    public void delete(Personal persistence) {
        personalDao.delete(persistence);
    }

    @Override
    public Personal get(Integer id) {
        return personalDao.get(id);
    }

    @Override
    public List<Personal> getAll(int pageNumber, int pageSize) {
        return personalDao.getAll(pageNumber, pageSize);
    }

    @Override
    public List<Personal> findByCriteria(Object obj) {
        return null;
    }
}
