package com.profilactory.model.dao.hibernate;

import com.profilactory.model.entity.Post;
import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ValentinBlokhin on 4/16/2014.
 */
@Component
public class PostHibernateDao extends AbstractHibernateDao<Post> {
    @Override
    public void saveOrUpdate(Post persistence) {
        getSession().saveOrUpdate(persistence);
    }

    @Override
    public void delete(Post persistence) {
        getSession().delete(persistence);
    }


    @Override
    public Post get(Integer id) {
        return (Post) getSession().load(Post.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Post> getAll(int pageNumber, int pageSize) {
        Query query = getSession().createQuery("from Post");
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);
        return query.list();
    }
}
