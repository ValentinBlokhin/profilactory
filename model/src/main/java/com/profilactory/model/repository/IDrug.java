package com.profilactory.model.repository;

import com.profilactory.model.entity.Drug;

import java.util.List;

/**
 * Created by ValentinBlokhin on 6/9/2014.
 */
public interface IDrug {
    List findDrugByPatientId(Integer id);
}
