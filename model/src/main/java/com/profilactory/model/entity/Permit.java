package com.profilactory.model.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by ValentinBlokhin on 4/16/2014.
 */
@Entity
public class Permit {
    private int permitId;

    private Date checkIn;
    private Date checkOut;
    private Integer roomId;
    private int patientId;
    private Collection<CurrentProcedure> currentProceduresByPermitId;
    private Patient patientByPatientId;
    private Room roomByRoomId;

    @Id
    @Column(name = "PERMIT_ID")
    public int getPermitId() {
        return permitId;
    }

    public void setPermitId(int permitId) {
        this.permitId = permitId;
    }

    @Basic
    @Column(name = "CHECK_IN")
    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    @Basic
    @Column(name = "CHECK_OUT")
    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    @Basic
    @Column(name = "ROOM_ID")
    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "PATIENT_ID")
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permit permit = (Permit) o;

        if (patientId != permit.patientId) return false;
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
        result = 31 * result + patientId;
        return result;
    }

    @OneToMany(mappedBy = "permitByPermitId")
    public Collection<CurrentProcedure> getCurrentProceduresByPermitId() {
        return currentProceduresByPermitId;
    }

    public void setCurrentProceduresByPermitId(Collection<CurrentProcedure> currentProceduresByPermitId) {
        this.currentProceduresByPermitId = currentProceduresByPermitId;
    }

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "PATIENT_ID", nullable = false, insertable = false, updatable = false)
    public Patient getPatientByPatientId() {
        return patientByPatientId;
    }

    public void setPatientByPatientId(Patient patientByPatientId) {
        this.patientByPatientId = patientByPatientId;
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
