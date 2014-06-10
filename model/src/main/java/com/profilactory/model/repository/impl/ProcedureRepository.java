package com.profilactory.model.repository.impl;

import com.profilactory.model.entity.Procedure;
import com.profilactory.model.repository.AbstractRepository;
import com.profilactory.model.repository.IProcedure;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ValentinBlokhin on 6/8/2014.
 */
@Repository
public class ProcedureRepository extends AbstractRepository implements IProcedure {
    @Override
    public List<Procedure> findProcedureByPatientId(Integer id) {
        Query query = getSession().createQuery("select procedure from Permit as permit " +
                "inner join permit.currentProceduresByPermitId as currPat " +
                "inner join currPat.procedureByProcedureId as procedure where permit.patientId = " + id);
        return query.list();
    }

    @Override
    public List findPassedProceduresByPatientId(Integer id) {
        Query query = getSession().createQuery("select procedure.name, count(distinct procedure.name) from Procedure as procedure inner join procedure.currentProceduresByProcedureId as currProc inner  join  currProc.permitByPermitId as permits inner join permits.currentProceduresByPermitId where currProc.status = 'passed' and permits.patientId = " + id + " " +
                "group by procedure.name");

        return query.list();
    }
}
