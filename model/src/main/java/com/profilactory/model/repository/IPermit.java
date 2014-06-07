package com.profilactory.model.repository;

import com.profilactory.model.entity.Permit;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by ValentinBlokhin on 6/3/2014.
 */
public interface IPermit {

    List<Permit> findPermitOnDate(String checkIn, String checkOut) throws ParseException;
}
