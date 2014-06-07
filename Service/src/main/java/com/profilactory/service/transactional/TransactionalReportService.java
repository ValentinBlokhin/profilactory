package com.profilactory.service.transactional;

import com.profilactory.model.entity.Permit;
import com.profilactory.model.repository.IPermit;
import com.profilactory.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by ValentinBlokhin on 6/1/2014.
 */
@Service("ReportService")
public class TransactionalReportService implements ReportService {


    @Autowired
    private IPermit permitRepository;

    @Override
    public List<Permit> findPermitByDate(String checkIn, String checkOut) throws ParseException {

        return permitRepository.findPermitOnDate(checkIn, checkOut);

    }
}
