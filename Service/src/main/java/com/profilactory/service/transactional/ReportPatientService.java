package com.profilactory.service.transactional;

import com.profilactory.model.entity.*;
import com.profilactory.model.repository.*;
import com.profilactory.service.IReportPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ValentinBlokhin on 6/8/2014.
 */
@Service
public class ReportPatientService implements IReportPatientService {

    @Autowired
    private IPatient patientRepository;

    @Autowired
    private IDiagnosis diagnosisRepository;

    @Autowired
    private IProcedure procedureRepository;

    @Autowired
    private IRoom roomRepository;

    @Autowired
    private IDrug drugRepository;

    @Override
    public List<Permit> findPermitByPatientId(Integer id) {
        return patientRepository.findPermitByPatient(id);
    }

    @Override
    public List<Diagnosis> findDiagnosisForPatient(Integer id) {
        return diagnosisRepository.findDiagnosisForPatient(id);
    }

    @Override
    public List<Procedure> findProcedureByPatientId(Integer id) {
        return procedureRepository.findProcedureByPatientId(id);
    }

    @Override
    public List findPassedProceduresByPatientId(Integer id) {
        return procedureRepository.findPassedProceduresByPatientId(id);
    }

    @Override
    public List<Room> findRoomByPatientId(Integer id) {
        return roomRepository.findRoomByPatientId(id);
    }

    @Override
    public List findDrugByPatientId(Integer id) {
        return drugRepository.findDrugByPatientId(id);
    }


}
