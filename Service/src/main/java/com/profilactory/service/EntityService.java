package com.profilactory.service;

import java.util.List;

/**
 * Created by ValentinBlokhin on 4/7/2014.
 */
public interface EntityService<T> {

    void save(T persistence);

    void update(T persistence);

    void delete(T persistence);

    T get(Integer id);

    List<T> getAll(int pageNumber, int pageSize);

    List<T> findByCriteria(Object obj);

}
