package com.profilactory.model.entity;

import javax.persistence.*;

/**
 * Created by ValentinBlokhin on 4/16/2014.
 */
@Entity
@Table(name = "CURRENT_PATIENT")
public class CurrentPatient {
    private int patientId;
    private int drugDiagnosisDrugId;
    private int drugDiagnosisDiagnosisId;
    private int currentPatientId;
    private DrugDiagnosis drugDiagnosis;
    private Patient patientByPatientId;

    @Basic
    @Column(name = "PATIENT_ID")
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Basic
    @Column(name = "DRUG_DIAGNOSIS_DRUG_ID")
    public int getDrugDiagnosisDrugId() {
        return drugDiagnosisDrugId;
    }

    public void setDrugDiagnosisDrugId(int drugDiagnosisDrugId) {
        this.drugDiagnosisDrugId = drugDiagnosisDrugId;
    }

    @Basic
    @Column(name = "DRUG_DIAGNOSIS_DIAGNOSIS_ID")
    public int getDrugDiagnosisDiagnosisId() {
        return drugDiagnosisDiagnosisId;
    }

    public void setDrugDiagnosisDiagnosisId(int drugDiagnosisDiagnosisId) {
        this.drugDiagnosisDiagnosisId = drugDiagnosisDiagnosisId;
    }

    @Id
    @Column(name = "CURRENT_PATIENT_ID")
    public int getCurrentPatientId() {
        return currentPatientId;
    }

    public void setCurrentPatientId(int currentPatientId) {
        this.currentPatientId = currentPatientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurrentPatient that = (CurrentPatient) o;

        if (currentPatientId != that.currentPatientId) return false;
        if (drugDiagnosisDiagnosisId != that.drugDiagnosisDiagnosisId) return false;
        if (drugDiagnosisDrugId != that.drugDiagnosisDrugId) return false;
        if (patientId != that.patientId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = patientId;
        result = 31 * result + drugDiagnosisDrugId;
        result = 31 * result + drugDiagnosisDiagnosisId;
        result = 31 * result + currentPatientId;
        return result;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "DRUG_DIAGNOSIS_DIAGNOSIS_ID", referencedColumnName = "ID_DRUG", nullable = false, insertable = false, updatable = false), @JoinColumn(name = "DRUG_DIAGNOSIS_DRUG_ID", referencedColumnName = "ID_DIAGNOSIS", nullable = false, insertable = false, updatable = false)})
    public DrugDiagnosis getDrugDiagnosis() {
        return drugDiagnosis;
    }

    public void setDrugDiagnosis(DrugDiagnosis drugDiagnosis) {
        this.drugDiagnosis = drugDiagnosis;
    }

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "PATIENT_ID", nullable = false, insertable = false, updatable = false)
    public Patient getPatientByPatientId() {
        return patientByPatientId;
    }

    public void setPatientByPatientId(Patient patientByPatientId) {
        this.patientByPatientId = patientByPatientId;
    }
}
