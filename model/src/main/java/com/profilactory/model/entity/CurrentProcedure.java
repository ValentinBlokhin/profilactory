package com.profilactory.model.entity;

import javax.persistence.*;

/**
 * Created by ValentinBlokhin on 4/16/2014.
 */
@Entity
@Table(name = "CURRENT_PROCEDURE")
public class CurrentProcedure {
    private int currentProcedureId;
    private int procedureId;
    private int cabinetId;
    private String status;
    private int permitId;
    private Cabinet cabinetByCabinetId;
    private Permit permitByPermitId;
    private Procedure procedureByProcedureId;

    @Id
    @Column(name = "CURRENT_PROCEDURE_ID")
    public int getCurrentProcedureId() {
        return currentProcedureId;
    }

    public void setCurrentProcedureId(int currentProcedureId) {
        this.currentProcedureId = currentProcedureId;
    }

    @Basic
    @Column(name = "PROCEDURE_ID")
    public int getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(int procedureId) {
        this.procedureId = procedureId;
    }

    @Basic
    @Column(name = "CABINET_ID")
    public int getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(int cabinetId) {
        this.cabinetId = cabinetId;
    }

    @Basic
    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "PERMIT_ID")
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

        CurrentProcedure that = (CurrentProcedure) o;

        if (cabinetId != that.cabinetId) return false;
        if (currentProcedureId != that.currentProcedureId) return false;
        if (permitId != that.permitId) return false;
        if (procedureId != that.procedureId) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = currentProcedureId;
        result = 31 * result + procedureId;
        result = 31 * result + cabinetId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + permitId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CABINET_ID", referencedColumnName = "CABINET_ID", nullable = false, insertable = false, updatable = false)
    public Cabinet getCabinetByCabinetId() {
        return cabinetByCabinetId;
    }

    public void setCabinetByCabinetId(Cabinet cabinetByCabinetId) {
        this.cabinetByCabinetId = cabinetByCabinetId;
    }

    @ManyToOne
    @JoinColumn(name = "PERMIT_ID", referencedColumnName = "PERMIT_ID", nullable = false, insertable = false, updatable = false)
    public Permit getPermitByPermitId() {
        return permitByPermitId;
    }

    public void setPermitByPermitId(Permit permitByPermitId) {
        this.permitByPermitId = permitByPermitId;
    }

    @ManyToOne
    @JoinColumn(name = "PROCEDURE_ID", referencedColumnName = "PROCEDURE_ID", nullable = false, insertable = false, updatable = false)
    public Procedure getProcedureByProcedureId() {
        return procedureByProcedureId;
    }

    public void setProcedureByProcedureId(Procedure procedureByProcedureId) {
        this.procedureByProcedureId = procedureByProcedureId;
    }
}
