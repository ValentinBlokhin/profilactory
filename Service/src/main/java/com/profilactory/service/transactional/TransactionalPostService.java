package com.profilactory.service.transactional;

import com.profilactory.model.dao.Dao;
import com.profilactory.model.dao.hibernate.PostHibernateDao;
import com.profilactory.model.entity.Post;
import com.profilactory.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ValentinBlokhin on 4/16/2014.
 */
@Service("PostService")
public class TransactionalPostService implements EntityService<Post> {

    @Autowired
    @Qualifier("postHibernateDao")
    private Dao<Post> dao;

    @Override
    public void saveOrUpdate(Post persistence) {
        dao.saveOrUpdate(persistence);
    }

    @Override
    public void delete(Post persistence) {
        dao.delete(persistence);
    }

    @Override
    public Post get(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<Post> getAll(int pageNumber, int pageSize) {
        return dao.getAll(pageNumber, pageSize);
    }
}
