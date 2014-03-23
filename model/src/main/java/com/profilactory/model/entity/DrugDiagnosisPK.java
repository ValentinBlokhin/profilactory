package com.profilactory.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ValentinBlokhin on 3/23/2014.
 */
public class DrugDiagnosisPK implements Serializable {
    private int idDrug;
    private int idDiagnosis;

    @Column(name = "ID_DRUG", nullable = false, insertable = true, updatable = true, precision = 0)
    @Id
    public int getIdDrug() {
        return idDrug;
    }

    public void setIdDrug(int idDrug) {
        this.idDrug = idDrug;
    }

    @Column(name = "ID_DIAGNOSIS", nullable = false, insertable = true, updatable = true, precision = 0)
    @Id
    public int getIdDiagnosis() {
        return idDiagnosis;
    }

    public void setIdDiagnosis(int idDiagnosis) {
        this.idDiagnosis = idDiagnosis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DrugDiagnosisPK that = (DrugDiagnosisPK) o;

        if (idDiagnosis != that.idDiagnosis) return false;
        if (idDrug != that.idDrug) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idDrug;
        result = 31 * result + idDiagnosis;
        return result;
    }
}
