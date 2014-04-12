package com.profilactory.model.dao.hibernate;

import com.profilactory.model.dao.databasefilter.DataBaseFilter;
import com.profilactory.model.entity.Personal;
import org.hibernate.SessionFactory;
import org.junit.After;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ValentinBlokhin on 3/30/2014.
 */

@ContextConfiguration(locations = "classpath*:/dao/Personal/springconfig/personal-hibernate-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class PersonalHibernateDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
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
        Personal personal = new Personal();
        personal.setPersonalId(3);
        personal.setWorkTime("8:00 AM to 7:00 PM");
        personal.setPostId(2);
    }

    @Test
    public void testDelete() throws Exception {
        Personal personal = new Personal();
        personal.setPersonalId(3);
        personal.setWorkTime("8:00 AM to 7:00 PM");
        personal.setPostId(1);
        personalHibernateDao.saveOrUpdate(personal);

        assertEquals(personalHibernateDao.getAll(0, 10).size(), 3);
        personalHibernateDao.delete(personal);
        assertEquals(personalHibernateDao.getAll(0, 10).size(), 2);
    }

    @Test
    public void testGet() throws Exception {
        assertNotNull(personalHibernateDao.get(1));
    }

    @Test
    public void testGetAll() throws Exception {
        List<Personal> personals = personalHibernateDao.getAll(0, 2);
        assertEquals(personals.size(), 2);
    }
}
