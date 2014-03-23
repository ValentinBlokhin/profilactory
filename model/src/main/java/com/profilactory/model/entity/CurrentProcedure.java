package com.profilactory.model.entity;

import javax.persistence.*;

/**
 * Created by ValentinBlokhin on 3/23/2014.
 */
@Entity
@Table(name = "CURRENT_PROCEDURE", schema = "VALENTIN", catalog = "")
public class CurrentProcedure {
    private int currentProcedureId;
    private int patientId;
    private int procedureId;
    private int cabinetId;
    private String status;
    private Cabinet cabinetByCabinetId;
    private Patient patientByPatientId;
    private Procedure procedureByProcedureId;

    @Id
    @Column(name = "CURRENT_PROCEDURE_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getCurrentProcedureId() {
        return currentProcedureId;
    }

    public void setCurrentProcedureId(int currentProcedureId) {
        this.currentProcedureId = currentProcedureId;
    }

    @Basic
    @Column(name = "PATIENT_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Basic
    @Column(name = "PROCEDURE_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(int procedureId) {
        this.procedureId = procedureId;
    }

    @Basic
    @Column(name = "CABINET_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(int cabinetId) {
        this.cabinetId = cabinetId;
    }

    @Basic
    @Column(name = "STATUS", nullable = true, insertable = true, updatable = true, length = 20)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrentProcedure that = (CurrentProcedure) o;

        if (cabinetId != that.cabinetId) return false;
        if (currentProcedureId != that.currentProcedureId) return false;
        if (patientId != that.patientId) return false;
        if (procedureId != that.procedureId) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = currentProcedureId;
        result = 31 * result + patientId;
        result = 31 * result + procedureId;
        result = 31 * result + cabinetId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CABINET_ID", referencedColumnName = "CABINET_ID", nullable = false)
    public Cabinet getCabinetByCabinetId() {
        return cabinetByCabinetId;
    }

    public void setCabinetByCabinetId(Cabinet cabinetByCabinetId) {
        this.cabinetByCabinetId = cabinetByCabinetId;
    }

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "PATIENT_ID", nullable = false)
    public Patient getPatientByPatientId() {
        return patientByPatientId;
    }

    public void setPatientByPatientId(Patient patientByPatientId) {
        this.patientByPatientId = patientByPatientId;
    }

    @ManyToOne
    @JoinColumn(name = "PROCEDURE_ID", referencedColumnName = "PROCEDURE_ID", nullable = false)
    public Procedure getProcedureByProcedureId() {
        return procedureByProcedureId;
    }

    public void setProcedureByProcedureId(Procedure procedureByProcedureId) {
        this.procedureByProcedureId = procedureByProcedureId;
    }
}
