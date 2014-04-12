package com.profilactory.service.transactional;

import com.profilactory.model.dao.Dao;
import com.profilactory.model.entity.Procedure;
import com.profilactory.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ValentinBlokhin on 4/9/2014.
 */
@Service("ProcedureService")
public class TransactionalProcedureService implements EntityService<Procedure> {

    @Autowired
    @Qualifier("procedureHibernateDao")
    Dao<Procedure> procedureDao;

    @Override
    public void saveOrUpdate(Procedure persistence) {
        procedureDao.saveOrUpdate(persistence);
    }

    @Override
    public void delete(Procedure persistence) {
        procedureDao.delete(persistence);
    }

    @Override
    public Procedure get(Integer id) {
        return procedureDao.get(id);
    }

    @Override
    public List<Procedure> getAll(int pageNumber, int pageSize) {
        return procedureDao.getAll(pageNumber, pageSize);
    }
}
