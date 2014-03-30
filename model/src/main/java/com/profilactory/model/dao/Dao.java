package com.profilactory.model.dao;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by ValentinBlokhin on 3/25/2014.
 */
@Transactional(Transactional.TxType.REQUIRED)
public interface Dao<T> {

    void saveOrUpdate(T persistence);

    void delete(Integer id);

    void delete(T persistence);

    T get(Integer id);

    List<T> getAll(int pageNumber, int pageSize);


}
