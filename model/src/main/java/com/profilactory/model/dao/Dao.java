package com.profilactory.model.dao;

import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by ValentinBlokhin on 3/25/2014.
 */
public interface Dao<T> {

    void save(T persistence);

    void update(T persistence);

    void delete(T persistence);

    T get(Integer id);

    List<T> getAll(int pageNumber, int pageSize);

    List<T> findByCriteria(Object obj);

}
