package com.profilactory.service.transactional;

import com.profilactory.model.dao.Dao;
import com.profilactory.model.entity.Permit;
import com.profilactory.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ValentinBlokhin on 4/9/2014.
 */
@Service("PermitService")
public class TransactionalPermitService implements EntityService<Permit> {

    @Autowired
    @Qualifier("permitHibernateDao")
    Dao<Permit> permitDao;

    @Override
    public void save(Permit persistence) {
        permitDao.save(persistence);
    }

    @Override
    public void update(Permit persistence) {
        permitDao.update(persistence);
    }

    @Override
    public void delete(Permit persistence) {
        permitDao.delete(persistence);
    }

    @Override
    public Permit get(Integer id) {
        return permitDao.get(id);
    }

    @Override
    public List<Permit> getAll(int pageNumber, int pageSize) {
        return permitDao.getAll(pageNumber, pageSize);
    }

    @Override
    public List<Permit> findByCriteria(Object obj) {
        return null;
    }
}
