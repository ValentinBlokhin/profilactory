package com.profilactory.model.dao.hibernate;

import com.profilactory.model.dao.databasefilter.DataBaseFilter;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by ValentinBlokhin on 3/30/2014.
 */

@ContextConfiguration(locations = "classpath*:/dao/Personal/springconfig/personal-hibernate-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class PersonalHibernateDaoTest extends AbstractJUnit4SpringContextTests {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Autowired
    private DataBaseFilter dataBaseFilter;

    private PersonalHibernateDao personalHibernateDao = new PersonalHibernateDao();
    ;

    @Before
    public void setUp() throws Exception {
        personalHibernateDao.setSessionFactory(sessionFactory);
        dataBaseFilter.fill();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSaveOrUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testGetAll() throws Exception {

    }
}
