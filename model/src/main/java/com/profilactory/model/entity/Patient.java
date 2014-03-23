package com.profilactory.model.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ValentinBlokhin on 3/23/2014.
 */
@Entity
public class Patient {
    private int patientId;
    private String firstName;
    private String secondName;
    private String middleName;
    private int studentId;
    private int permitId;
    private Collection<CurrentPatient> currentPatientsByPatientId;
    private Collection<CurrentProcedure> currentProceduresByPatientId;
    private Permit permitByPermitId;

    @Id
    @Column(name = "PATIENT_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Basic
    @Column(name = "FIRST_NAME", nullable = false, insertable = true, updatable = true, length = 30)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "SECOND_NAME", nullable = false, insertable = true, updatable = true, length = 30)
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "MIDDLE_NAME", nullable = false, insertable = true, updatable = true, length = 30)
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "STUDENT_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "PERMIT_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getPermitId() {
        return permitId;
    }

    public void setPermitId(int permitId) {
        this.permitId = permitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (patientId != patient.patientId) return false;
        if (permitId != patient.permitId) return false;
        if (studentId != patient.studentId) return false;
        if (firstName != null ? !firstName.equals(patient.firstName) : patient.firstName != null) return false;
        if (middleName != null ? !middleName.equals(patient.middleName) : patient.middleName != null) return false;
        if (secondName != null ? !secondName.equals(patient.secondName) : patient.secondName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = patientId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + studentId;
        result = 31 * result + permitId;
        return result;
    }

    @OneToMany(mappedBy = "patientByPatientId")
    public Collection<CurrentPatient> getCurrentPatientsByPatientId() {
        return currentPatientsByPatientId;
    }

    public void setCurrentPatientsByPatientId(Collection<CurrentPatient> currentPatientsByPatientId) {
        this.currentPatientsByPatientId = currentPatientsByPatientId;
    }

    @OneToMany(mappedBy = "patientByPatientId")
    public Collection<CurrentProcedure> getCurrentProceduresByPatientId() {
        return currentProceduresByPatientId;
    }

    public void setCurrentProceduresByPatientId(Collection<CurrentProcedure> currentProceduresByPatientId) {
        this.currentProceduresByPatientId = currentProceduresByPatientId;
    }

    @ManyToOne
    @JoinColumn(name = "PERMIT_ID", referencedColumnName = "PERMIT_ID", nullable = false)
    public Permit getPermitByPermitId() {
        return permitByPermitId;
    }

    public void setPermitByPermitId(Permit permitByPermitId) {
        this.permitByPermitId = permitByPermitId;
    }
}
