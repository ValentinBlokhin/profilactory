package com.profilactory.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by ValentinBlokhin on 3/23/2014.
 */
@Entity
public class Permit {
    private int permitId;
    private Timestamp checkIn;
    private Timestamp checkOut;
    private Integer roomId;
    private Collection<Patient> patientsByPermitId;
    private Room roomByRoomId;

    @Id
    @Column(name = "PERMIT_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getPermitId() {
        return permitId;
    }

    public void setPermitId(int permitId) {
        this.permitId = permitId;
    }

    @Basic
    @Column(name = "CHECK_IN", nullable = false, insertable = true, updatable = true)
    public Timestamp getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Timestamp checkIn) {
        this.checkIn = checkIn;
    }

    @Basic
    @Column(name = "CHECK_OUT", nullable = false, insertable = true, updatable = true)
    public Timestamp getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Timestamp checkOut) {
        this.checkOut = checkOut;
    }

    @Basic
    @Column(name = "ROOM_ID", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permit permit = (Permit) o;

        if (permitId != permit.permitId) return false;
        if (checkIn != null ? !checkIn.equals(permit.checkIn) : permit.checkIn != null) return false;
        if (checkOut != null ? !checkOut.equals(permit.checkOut) : permit.checkOut != null) return false;
        if (roomId != null ? !roomId.equals(permit.roomId) : permit.roomId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = permitId;
        result = 31 * result + (checkIn != null ? checkIn.hashCode() : 0);
        result = 31 * result + (checkOut != null ? checkOut.hashCode() : 0);
        result = 31 * result + (roomId != null ? roomId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "permitByPermitId")
    public Collection<Patient> getPatientsByPermitId() {
        return patientsByPermitId;
    }

    public void setPatientsByPermitId(Collection<Patient> patientsByPermitId) {
        this.patientsByPermitId = patientsByPermitId;
    }

    @ManyToOne
    @JoinColumn(name = "ROOM_ID", referencedColumnName = "ROOM_ID", insertable = false, updatable = false)
    public Room getRoomByRoomId() {
        return roomByRoomId;
    }

    public void setRoomByRoomId(Room roomByRoomId) {
        this.roomByRoomId = roomByRoomId;
    }

}
