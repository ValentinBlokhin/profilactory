package com.profilactory.model.entity;

import javax.persistence.*;

/**
 * Created by ValentinBlokhin on 3/23/2014.
 */
@Entity
@Table(name = "CURRENT_PATIENT", schema = "VALENTIN", catalog = "")
public class CurrentPatient {
    private int currentPatientId;
    private int patientId;
    private int drugDiagnosisDrugId;
    private int drugDiagnosisDiagnosisId;
    private DrugDiagnosis drugDiagnosis;
    private Patient patientByPatientId;

    @Id
    @Column(name = "CURRENT_PATIENT_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getCurrentPatientId() {
        return currentPatientId;
    }

    public void setCurrentPatientId(int currentPatientId) {
        this.currentPatientId = currentPatientId;
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
    @Column(name = "DRUG_DIAGNOSIS_DRUG_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getDrugDiagnosisDrugId() {
        return drugDiagnosisDrugId;
    }

    public void setDrugDiagnosisDrugId(int drugDiagnosisDrugId) {
        this.drugDiagnosisDrugId = drugDiagnosisDrugId;
    }

    @Basic
    @Column(name = "DRUG_DIAGNOSIS_DIAGNOSIS_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getDrugDiagnosisDiagnosisId() {
        return drugDiagnosisDiagnosisId;
    }

    public void setDrugDiagnosisDiagnosisId(int drugDiagnosisDiagnosisId) {
        this.drugDiagnosisDiagnosisId = drugDiagnosisDiagnosisId;
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
        int result = currentPatientId;
        result = 31 * result + patientId;
        result = 31 * result + drugDiagnosisDrugId;
        result = 31 * result + drugDiagnosisDiagnosisId;
        return result;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "DRUG_DIAGNOSIS_DRUG_ID", referencedColumnName = "ID_DRUG", nullable = false), @JoinColumn(name = "DRUG_DIAGNOSIS_DIAGNOSIS_ID", referencedColumnName = "ID_DIAGNOSIS", nullable = false)})
    public DrugDiagnosis getDrugDiagnosis() {
        return drugDiagnosis;
    }

    public void setDrugDiagnosis(DrugDiagnosis drugDiagnosis) {
        this.drugDiagnosis = drugDiagnosis;
    }

    @ManyToOne
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "PATIENT_ID", nullable = false)
    public Patient getPatientByPatientId() {
        return patientByPatientId;
    }

    public void setPatientByPatientId(Patient patientByPatientId) {
        this.patientByPatientId = patientByPatientId;
    }
}
