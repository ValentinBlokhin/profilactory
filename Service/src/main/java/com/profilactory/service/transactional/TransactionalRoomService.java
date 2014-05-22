package com.profilactory.service.transactional;

import com.profilactory.model.dao.Dao;
import com.profilactory.model.dao.hibernate.RoomHibernateDao;
import com.profilactory.model.entity.Room;
import com.profilactory.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ValentinBlokhin on 4/7/2014.
 */
@Service("RoomService")
public class TransactionalRoomService implements EntityService<Room> {

    @Autowired
    @Qualifier("roomHibernateDao")
    private Dao<Room> dao;


    @Override
    public void save(Room persistence) {
        dao.save(persistence);
    }

    @Override
    public void update(Room persistence) {
        dao.update(persistence);
    }

    @Override
    public void delete(Room persistence) {
        dao.delete(persistence);
    }

    @Override
    public Room get(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<Room> getAll(int pageNumber, int pageSize) {
        return dao.getAll(pageNumber, pageSize);
    }

    @Override
    public List<Room> findByCriteria(Object obj) {
        return dao.findByCriteria(obj);
    }
}
