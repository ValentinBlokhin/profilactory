package com.profilactory.model.dao.hibernate;

import com.profilactory.model.entity.Room;
import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ValentinBlokhin on 3/26/2014.
 */

@Component
public class RoomHibernateDao extends AbstractHibernateDao<Room> {

    @Override
    public void save(Room persistence) {
        getSession().save(persistence);
    }

    @Override
    public void update(Room persistence) {
        getSession().update(persistence);
    }


    @Override
    public void delete(Room persistence) {
        getSession().delete(persistence);
    }

    @Override
    public Room get(Integer id) {
        return (Room) getSession().load(Room.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Room> getAll(int pageNumber, int pageSize) {
        Query query = getSession().createQuery("FROM Room");
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);
        return query.list();
    }

    @Override
    public List<Room> findByCriteria(Object obj) {
        Query query = getSession().createQuery("from Room where roomNumber = " + obj);

        return query.list();
    }


}
