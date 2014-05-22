package com.profilactory.model.dao.hibernate;

import com.profilactory.model.dao.databasefilter.DataBaseFilter;
import com.profilactory.model.entity.Post;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ValentinBlokhin on 4/16/2014.
 */
@ContextConfiguration(locations = "classpath:/dao/Post/springconfig/post-hibernate-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class PostHibernateDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    @Qualifier("sessionFactory")
    SessionFactory sessionFactory;

    PostHibernateDao dao = new PostHibernateDao();

    @Autowired
    DataBaseFilter dataBaseFilter;

    @Before
    public void setUp() throws Exception {
        dao.setSessionFactory(sessionFactory);
        dataBaseFilter.fill();
    }

    @Test
    public void testSave() throws Exception {
        Post post = new Post();
        post.setPostId(3);
        post.setName("test3");
        dao.save(post);
        assertEquals(dao.getAll(0, 3).size(), 3);

    }

    @Test
    public void testDelete() throws Exception {
        Post post = new Post();
        post.setPostId(3);
        post.setName("test3");
        dao.save(post);
        dao.delete(post);
        assertEquals(dao.getAll(0, 10).size(), 2);
    }

    @Test
    public void testGet() throws Exception {
        Post post = dao.get(2);
        assertNotNull(post);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Post> postList = dao.getAll(0, 10);
        assertEquals(postList.size(), 2);
    }
}
