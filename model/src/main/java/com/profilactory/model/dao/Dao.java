package com.profilactory.model.dao;

import java.util.List;

/**
 * Created by ValentinBlokhin on 3/25/2014.
 */
public interface Dao<T> {

    void saveOrUpdate(T persistence);

    void delete(Long id);

    void delete(T persistence);

    T get(Long id);

    List<T> getAll(int pageNumber, int pageSize);


}
