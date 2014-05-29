package com.profilactory.model.entity;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * Created by ValentinBlokhin on 4/16/2014.
 */
@Entity
public class Room {


    private int roomId;
    @NotNull
    @Range(min = 1, max = 999)
    private int roomNumber;

    @NotNull
    @Range(min = 1, max = 4)
    private int seats;

    private int busySeats;


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

    @Basic
    @Column(name = "BUSYSEATS")
    public int getBusySeats() {
        return busySeats;
    }

    public void setBusySeats(int busySeats) {
        this.busySeats = busySeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (busySeats != room.busySeats) return false;
        if (roomId != room.roomId) return false;
        if (roomNumber != room.roomNumber) return false;
        if (seats != room.seats) return false;
        if (permitsByRoomId != null ? !permitsByRoomId.equals(room.permitsByRoomId) : room.permitsByRoomId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roomId;
        result = 31 * result + roomNumber;
        result = 31 * result + seats;
        result = 31 * result + busySeats;
        result = 31 * result + (permitsByRoomId != null ? permitsByRoomId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "roomByRoomId")
    public Collection<Permit> getPermitsByRoomId() {
        return permitsByRoomId;
    }

    public void setPermitsByRoomId(Collection<Permit> permitsByRoomId) {
        this.permitsByRoomId = permitsByRoomId;
    }

//    @Override
//    public String toString() {
//        return String.valueOf(roomNumber);
//    }
}
