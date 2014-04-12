package com.profilactory.service.transactional;

import com.profilactory.model.dao.Dao;
import com.profilactory.model.entity.Cabinet;
import com.profilactory.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ValentinBlokhin on 4/9/2014.
 */
@Service("CabinetService")
public class TransactionalCabinetService implements EntityService<Cabinet> {

    @Autowired
    @Qualifier("cabinetHibernateDao")
    Dao<Cabinet> cabinetDao;

    @Override
    public void saveOrUpdate(Cabinet persistence) {
        cabinetDao.saveOrUpdate(persistence);
    }

    @Override
    public void delete(Cabinet persistence) {
        cabinetDao.delete(persistence);
    }

    @Override
    public Cabinet get(Integer id) {
        return cabinetDao.get(id);
    }

    @Override
    public List<Cabinet> getAll(int pageNumber, int pageSize) {
        return cabinetDao.getAll(pageNumber, pageSize);
    }
}
