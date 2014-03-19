package com.profilactory.model.entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Валентин
 * Date: 17.03.14
 * Time: 21:04
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seats")
    private Long seats;
    @Column(name = "room_number")
    private Long roomNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSeats() {
        return seats;
    }

    public void setSeats(Long seats) {
        this.seats = seats;
    }

    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }
}
