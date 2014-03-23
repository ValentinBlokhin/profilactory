package com.profilactory.model.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ValentinBlokhin on 3/23/2014.
 */
@Entity
public class Procedure {
    private int procedureId;
    private String name;
    private String purpose;
    private Collection<CurrentProcedure> currentProceduresByProcedureId;

    @Id
    @Column(name = "PROCEDURE_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(int procedureId) {
        this.procedureId = procedureId;
    }

    @Basic
    @Column(name = "NAME", nullable = false, insertable = true, updatable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "PURPOSE", nullable = false, insertable = true, updatable = true, length = 50)
    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Procedure procedure = (Procedure) o;

        if (procedureId != procedure.procedureId) return false;
        if (name != null ? !name.equals(procedure.name) : procedure.name != null) return false;
        if (purpose != null ? !purpose.equals(procedure.purpose) : procedure.purpose != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = procedureId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (purpose != null ? purpose.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "procedureByProcedureId")
    public Collection<CurrentProcedure> getCurrentProceduresByProcedureId() {
        return currentProceduresByProcedureId;
    }

    public void setCurrentProceduresByProcedureId(Collection<CurrentProcedure> currentProceduresByProcedureId) {
        this.currentProceduresByProcedureId = currentProceduresByProcedureId;
    }
}
