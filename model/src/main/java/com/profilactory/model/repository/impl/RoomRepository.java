package com.profilactory.model.repository.impl;

import com.profilactory.model.entity.Room;
import com.profilactory.model.repository.AbstractRepository;
import com.profilactory.model.repository.IRoom;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ValentinBlokhin on 6/8/2014.
 */
@Repository
public class RoomRepository extends AbstractRepository implements IRoom {
    @Override
    public List<Room> findRoomByPatientId(Integer id) {
        Query query = getSession().createQuery("select rooms from Permit as permit inner join permit.roomByRoomId as rooms where  permit.patientId = " + id);
        return query.list();
    }

    @Override
    public boolean checkFreeSeats(Integer id) {
        List<Room> listQueryForFree = getSession().createQuery("select distinct rooms from Permit as permit inner join permit.roomByRoomId as rooms where permit.roomId = " + id).list();
        Room room = listQueryForFree.get(0);
        int freeSeats = room.getSeats();
        int busySeats = room.getBusySeats();

        return busySeats < freeSeats;
    }
}
