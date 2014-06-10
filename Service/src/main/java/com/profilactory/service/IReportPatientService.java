package com.profilactory.service;

import com.profilactory.model.entity.*;

import java.util.List;

/**
 * Created by ValentinBlokhin on 6/7/2014.
 */
public interface IReportPatientService {
    List<Permit> findPermitByPatientId(Integer id);

    List<Diagnosis> findDiagnosisForPatient(Integer id);

    List<Procedure> findProcedureByPatientId(Integer id);

    List findPassedProceduresByPatientId(Integer id);

    List<Room> findRoomByPatientId(Integer id);

    List findDrugByPatientId(Integer id);
}
