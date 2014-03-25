package com.profilactory.model.dao.hibernate;

import com.profilactory.model.dao.Dao;
import com.profilactory.model.entity.Cabinet;
import com.profilactory.model.entity.Diagnosis;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ValentinBlokhin on 3/25/2014.
 */
public class DiagnosisHibernateDao extends AbstractHibernateDao {


    @Override
    public void saveOrUpdate(Cabinet persistence) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(Cabinet persistence) {

    }

    @Override
    public Cabinet get(Long id) {
        return null;
    }

    @Override
    public List<Cabinet> getAll(int pageNumber, int pageSize) {
        return null;
    }
}
