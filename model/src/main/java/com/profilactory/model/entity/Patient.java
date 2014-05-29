package com.profilactory.model.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * Created by ValentinBlokhin on 4/16/2014.
 */
@Entity
public class Patient {
    private int patientId;

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String secondName;
    @NotEmpty
    private String middleName;
    @NotNull
    private int studentId;
    private Collection<CurrentPatient> currentPatientsByPatientId;
    private Collection<Permit> permitsByPatientId;

    @Id
    @Column(name = "PATIENT_ID")
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Basic
    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "SECOND_NAME")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "MIDDLE_NAME")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "STUDENT_ID")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (patientId != patient.patientId) return false;
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
    public Collection<Permit> getPermitsByPatientId() {
        return permitsByPatientId;
    }

    public void setPermitsByPatientId(Collection<Permit> permitsByPatientId) {
        this.permitsByPatientId = permitsByPatientId;
    }
}
