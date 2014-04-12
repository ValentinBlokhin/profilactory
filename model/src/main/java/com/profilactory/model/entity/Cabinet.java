package com.profilactory.model.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ValentinBlokhin on 4/16/2014.
 */
@Entity
public class Cabinet {
    private int cabinetId;
    private String name;
    private int personalId;
    private Personal personalByPersonalId;
    private Collection<CurrentProcedure> currentProceduresByCabinetId;

    @Id
    @Column(name = "CABINET_ID")
    public int getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(int cabinetId) {
        this.cabinetId = cabinetId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "PERSONAL_ID")
    public int getPersonalId() {
        return personalId;
    }

    public void setPersonalId(int personalId) {
        this.personalId = personalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cabinet cabinet = (Cabinet) o;

        if (cabinetId != cabinet.cabinetId) return false;
        if (personalId != cabinet.personalId) return false;
        if (name != null ? !name.equals(cabinet.name) : cabinet.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cabinetId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + personalId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PERSONAL_ID", referencedColumnName = "PERSONAL_ID", nullable = false, insertable = false, updatable = false)
    public Personal getPersonalByPersonalId() {
        return personalByPersonalId;
    }

    public void setPersonalByPersonalId(Personal personalByPersonalId) {
        this.personalByPersonalId = personalByPersonalId;
    }

    @OneToMany(mappedBy = "cabinetByCabinetId")
    public Collection<CurrentProcedure> getCurrentProceduresByCabinetId() {
        return currentProceduresByCabinetId;
    }

    public void setCurrentProceduresByCabinetId(Collection<CurrentProcedure> currentProceduresByCabinetId) {
        this.currentProceduresByCabinetId = currentProceduresByCabinetId;
    }
}
