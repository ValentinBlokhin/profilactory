package com.profilactory.model.repository.impl;

import com.profilactory.model.entity.Permit;
import com.profilactory.model.repository.AbstractRepository;
import com.profilactory.model.repository.IPatient;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ValentinBlokhin on 6/7/2014.
 */
@Repository
public class PatientRepository extends AbstractRepository implements IPatient {
    @Override
    public List<Permit> findPermitByPatient(Integer id) {
        Query query = getSession().createQuery("from Permit as permit where permit.patientId = " + id);
        return query.list();
    }
}
