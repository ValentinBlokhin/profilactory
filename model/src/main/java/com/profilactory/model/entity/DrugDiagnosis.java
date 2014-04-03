package com.profilactory.model.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ValentinBlokhin on 3/23/2014.
 */
@Entity
@Table(name = "DRUG_DIAGNOSIS")
@IdClass(DrugDiagnosisPK.class)
public class DrugDiagnosis {
    private int idDrug;
    private int idDiagnosis;
    private Collection<CurrentPatient> currentPatients;
    private Diagnosis diagnosisByIdDiagnosis;
    private Drug drugByIdDrug;

    @Id
    @Column(name = "ID_DRUG")
    public int getIdDrug() {
        return idDrug;
    }

    public void setIdDrug(int idDrug) {
        this.idDrug = idDrug;
    }

    @Id
    @Column(name = "ID_DIAGNOSIS")
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

        DrugDiagnosis that = (DrugDiagnosis) o;

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

    @OneToMany(mappedBy = "drugDiagnosis")
    public Collection<CurrentPatient> getCurrentPatients() {
        return currentPatients;
    }

    public void setCurrentPatients(Collection<CurrentPatient> currentPatients) {
        this.currentPatients = currentPatients;
    }

    @ManyToOne
    @JoinColumn(name = "ID_DIAGNOSIS", referencedColumnName = "DIAGNOSIS_ID", insertable = false, updatable = false)
    public Diagnosis getDiagnosisByIdDiagnosis() {
        return diagnosisByIdDiagnosis;
    }

    public void setDiagnosisByIdDiagnosis(Diagnosis diagnosisByIdDiagnosis) {
        this.diagnosisByIdDiagnosis = diagnosisByIdDiagnosis;
    }

    @ManyToOne
    @JoinColumn(name = "ID_DRUG", referencedColumnName = "DRUG_ID", insertable = false, updatable = false)
    public Drug getDrugByIdDrug() {
        return drugByIdDrug;
    }

    public void setDrugByIdDrug(Drug drugByIdDrug) {
        this.drugByIdDrug = drugByIdDrug;
    }
}
