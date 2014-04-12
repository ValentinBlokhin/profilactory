package com.profilactory.service.transactional;

import com.profilactory.model.dao.Dao;
import com.profilactory.model.entity.CurrentProcedure;
import com.profilactory.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ValentinBlokhin on 4/9/2014.
 */
@Service("CurrentProcedureService")
public class TransactionalCurrentProcedureService implements EntityService<CurrentProcedure> {

    @Autowired
    Dao<CurrentProcedure> currentProcedureDao;

    @Override
    public void saveOrUpdate(CurrentProcedure persistence) {
        currentProcedureDao.saveOrUpdate(persistence);
    }

    @Override
    public void delete(CurrentProcedure persistence) {
        currentProcedureDao.delete(persistence);
    }

    @Override
    public CurrentProcedure get(Integer id) {
        return currentProcedureDao.get(id);
    }

    @Override
    public List<CurrentProcedure> getAll(int pageNumber, int pageSize) {
        return currentProcedureDao.getAll(pageNumber, pageSize);
    }
}
