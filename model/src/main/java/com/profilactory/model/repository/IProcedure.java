package com.profilactory.model.repository;

import com.profilactory.model.entity.Procedure;

import java.util.List;

/**
 * Created by ValentinBlokhin on 6/8/2014.
 */
public interface IProcedure {
    List<Procedure> findProcedureByPatientId(Integer id);

    List findPassedProceduresByPatientId(Integer id);
}
