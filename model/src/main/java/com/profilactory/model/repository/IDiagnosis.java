package com.profilactory.model.repository;

import com.profilactory.model.entity.Diagnosis;

import java.util.List;

/**
 * Created by ValentinBlokhin on 6/8/2014.
 */
public interface IDiagnosis {
    List<Diagnosis> findDiagnosisForPatient(Integer id);
}
