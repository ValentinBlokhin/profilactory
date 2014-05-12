package com.profilactory.model.entity;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Collection;

/**
 * Created by ValentinBlokhin on 4/16/2014.
 */
@Entity
public class Room {

    private int roomId;
    @NotNull
    @Range(min = 1)
    //@Pattern(regexp = "\\d+")
    private int roomNumber;

    @NotNull
    //@Pattern(regexp = "\\d+")
    @Range(min = 1, max = 4)
    private int seats;
    private Collection<Permit> permitsByRoomId;


    public Room(int roomId, int roomNumber, int seats) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.seats = seats;
    }

    public Room() {
    }

    @Id
    @Column(name = "ROOM_ID")
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "ROOM_NUMBER")
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Basic
    @Column(name = "SEATS")
    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (roomId != room.roomId) return false;
        if (roomNumber != room.roomNumber) return false;
        if (seats != room.seats) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roomId;
        result = 31 * result + roomNumber;
        result = 31 * result + seats;
        return result;
    }

    @OneToMany(mappedBy = "roomByRoomId")
    public Collection<Permit> getPermitsByRoomId() {
        return permitsByRoomId;
    }

    public void setPermitsByRoomId(Collection<Permit> permitsByRoomId) {
        this.permitsByRoomId = permitsByRoomId;
    }
}
