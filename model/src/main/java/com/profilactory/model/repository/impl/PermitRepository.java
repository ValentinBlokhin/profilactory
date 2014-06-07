package com.profilactory.model.repository.impl;

import com.profilactory.model.entity.Permit;
import com.profilactory.model.repository.AbstractRepository;
import com.profilactory.model.repository.IPermit;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by ValentinBlokhin on 6/3/2014.
 */
@Repository
public class PermitRepository extends AbstractRepository implements IPermit {


    @SuppressWarnings("unchecked")
    @Override
    public List findPermitOnDate(String checkIn, String checkOut) throws ParseException {

        Date checkInDate = Date.valueOf(checkIn);
        Date checkOutDate = Date.valueOf(checkOut);


        Query query = getSession().createQuery("from Patient as patient  inner join patient.permitsByPatientId as permit where permit.checkIn between to_date('" +
                checkInDate + "', 'yyyy/mm/dd')" + " and to_date('" + checkOutDate + "', 'yyyy/mm/dd')");
        return (List<Permit>) query.list();
    }
}
