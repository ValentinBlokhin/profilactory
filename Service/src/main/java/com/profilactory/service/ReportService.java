package com.profilactory.service;

import com.profilactory.model.entity.Permit;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by ValentinBlokhin on 6/1/2014.
 */
public interface ReportService {
    List<Permit> findPermitByDate(String checkIn, String checkOut) throws ParseException;

    boolean checkFreeSeats(Integer id);
}
