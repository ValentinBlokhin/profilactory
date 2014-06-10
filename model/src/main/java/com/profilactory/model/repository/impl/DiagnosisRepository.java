package com.profilactory.model.repository.impl;

import com.profilactory.model.entity.Diagnosis;
import com.profilactory.model.repository.AbstractRepository;
import com.profilactory.model.repository.IDiagnosis;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ValentinBlokhin on 6/8/2014.
 */
@Repository
public class DiagnosisRepository extends AbstractRepository implements IDiagnosis {
    @SuppressWarnings("unchecked")
    @Override
    public List<Diagnosis> findDiagnosisForPatient(Integer id) {
        Query query = getSession().createQuery("select diag from CurrentPatient as currPat" +
                " inner join currPat.drugDiagnosis  as dg inner join dg.diagnosisByIdDiagnosis as diag inner join diag.drugDiagnosisesByDiagnosisId where currPat.patientId = " + id);

        return query.list();
    }
}
