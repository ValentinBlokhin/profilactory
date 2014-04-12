package com.profilactory.service.transactional;

import com.profilactory.model.dao.Dao;
import com.profilactory.model.entity.Room;
import com.profilactory.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ValentinBlokhin on 4/7/2014.
 */
@Service("RoomService")
public class TransactionalRoomService implements EntityService<Room> {

    @Autowired
    private Dao<Room> dao;


    @Override
    public void saveOrUpdate(Room persistence) {
        dao.saveOrUpdate(persistence);
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
}
