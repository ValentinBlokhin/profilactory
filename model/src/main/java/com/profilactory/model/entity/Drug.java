package com.profilactory.model.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ValentinBlokhin on 3/23/2014.
 */
@Entity
public class Drug {
    private int drugId;
    private String name;
    private String type;
    private Collection<DrugDiagnosis> drugDiagnosisesByDrugId;

    @Id
    @Column(name = "DRUG_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getDrugId() {
        return drugId;
    }

    public void setDrugId(int drugId) {
        this.drugId = drugId;
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
    @Column(name = "TYPE", nullable = false, insertable = true, updatable = true, length = 30)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drug drug = (Drug) o;

        if (drugId != drug.drugId) return false;
        if (name != null ? !name.equals(drug.name) : drug.name != null) return false;
        if (type != null ? !type.equals(drug.type) : drug.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = drugId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "drugByIdDrug")
    public Collection<DrugDiagnosis> getDrugDiagnosisesByDrugId() {
        return drugDiagnosisesByDrugId;
    }

    public void setDrugDiagnosisesByDrugId(Collection<DrugDiagnosis> drugDiagnosisesByDrugId) {
        this.drugDiagnosisesByDrugId = drugDiagnosisesByDrugId;
    }
}
