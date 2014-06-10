package com.profilactory.model.repository.impl;

import com.profilactory.model.entity.Drug;
import com.profilactory.model.repository.AbstractRepository;
import com.profilactory.model.repository.IDrug;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ValentinBlokhin on 6/9/2014.
 */
@Repository
public class DrugRepository extends AbstractRepository implements IDrug {
    @Override
    public List<Drug> findDrugByPatientId(Integer id) {
        Query query = getSession().createQuery("select drug from CurrentPatient as currPat inner join currPat.drugDiagnosis as dg inner join dg.drugByIdDrug as drug inner join drug.drugDiagnosisesByDrugId where currPat.patientId = " + id);

        return query.list();
    }
}
