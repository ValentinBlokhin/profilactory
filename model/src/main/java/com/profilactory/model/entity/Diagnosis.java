package com.profilactory.model.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ValentinBlokhin on 4/16/2014.
 */
@Entity
public class Diagnosis {
    private int diagnosisId;
    private String name;
    private Collection<DrugDiagnosis> drugDiagnosisesByDiagnosisId;

    @Id
    @Column(name = "DIAGNOSIS_ID")
    public int getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(int diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Diagnosis diagnosis = (Diagnosis) o;

        if (diagnosisId != diagnosis.diagnosisId) return false;
        if (name != null ? !name.equals(diagnosis.name) : diagnosis.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = diagnosisId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "diagnosisByIdDiagnosis")
    public Collection<DrugDiagnosis> getDrugDiagnosisesByDiagnosisId() {
        return drugDiagnosisesByDiagnosisId;
    }

    public void setDrugDiagnosisesByDiagnosisId(Collection<DrugDiagnosis> drugDiagnosisesByDiagnosisId) {
        this.drugDiagnosisesByDiagnosisId = drugDiagnosisesByDiagnosisId;
    }
}
