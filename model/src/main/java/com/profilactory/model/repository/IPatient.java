package com.profilactory.model.repository;

import com.profilactory.model.entity.Permit;

import java.util.List;

/**
 * Created by ValentinBlokhin on 6/7/2014.
 */
public interface IPatient {
    List<Permit> findPermitByPatient(Integer id);
}
