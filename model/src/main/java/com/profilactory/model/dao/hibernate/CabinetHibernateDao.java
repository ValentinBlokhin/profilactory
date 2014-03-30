package com.profilactory.model.dao.hibernate;

import com.profilactory.model.entity.Cabinet;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by ValentinBlokhin on 3/25/2014.
 */
public class CabinetHibernateDao extends AbstractHibernateDao<Cabinet> {

    @Override
    public void saveOrUpdate(Cabinet persistence) {
        getSession().save(persistence);
    }

    @Override
    public void delete(Integer id) {
        Query query = getSession().createQuery("delete Cabinet where cabinetId = :cabinetId");
        query.setInteger("cabinetId", id);
        query.executeUpdate();
    }

    @Override
    public void delete(Cabinet persistence) {
        getSession().delete(persistence);
    }

    @Override
    public Cabinet get(Integer id) {
        return (Cabinet) getSession().load(Cabinet.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Cabinet> getAll(int pageNumber, int pageSize) {
        Query query = getSession().createQuery("from Cabinet");
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);
        return query.list();
    }

}
