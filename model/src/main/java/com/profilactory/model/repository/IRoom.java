package com.profilactory.model.repository;

import com.profilactory.model.entity.Room;

import java.util.List;

/**
 * Created by ValentinBlokhin on 6/8/2014.
 */
public interface IRoom {
    List<Room> findRoomByPatientId(Integer id);

    boolean checkFreeSeats(Integer id);
}
