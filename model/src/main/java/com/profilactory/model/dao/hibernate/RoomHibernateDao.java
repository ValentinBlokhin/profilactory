package com.profilactory.model.dao.hibernate;

import com.profilactory.model.entity.Room;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by ValentinBlokhin on 3/26/2014.
 */
public class RoomHibernateDao extends AbstractHibernateDao<Room> {
    @Override
    public void saveOrUpdate(Room persistence) {
        getSession().save(persistence);
    }

    @Override
    public void delete(Long id) {
        Query query = getSession().createQuery("from Room where roomId = :roomId");
        query.setLong("roomId", id);

    }

    @Override
    public void delete(Room persistence) {
        getSession().delete(persistence);
    }

    @Override
    public Room get(Long id) {
        return (Room) getSession().load(Room.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Room> getAll(int pageNumber, int pageSize) {
        Query query = getSession().createQuery("from Room ");
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);
        return query.list();
    }
}
