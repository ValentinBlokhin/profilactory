package com.profilactory.model.dao.hibernate;

import com.profilactory.model.dao.databasefilter.DataBaseFilter;
import com.profilactory.model.entity.Permit;
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

import java.sql.Timestamp;
import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ValentinBlokhin on 3/31/2014.
 */
@ContextConfiguration(locations = "classpath:dao/Permit/springconfig/permit-hibernate-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class PermitHibernateDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    private PermitHibernateDao permitHibernateDao = new PermitHibernateDao();

    @Autowired
    private DataBaseFilter dataBaseFilter;

    @Before
    public void setUp() throws Exception {
        permitHibernateDao.setSessionFactory(sessionFactory);
        dataBaseFilter.fill();
    }

    @Test
    public void testSave() throws Exception {
        Permit permit = new Permit();
        permit.setPermitId(3);
        java.util.Date date = new java.util.Date();
        permit.setCheckIn(new Date(date.getTime()));
        permit.setCheckOut(new Date(date.getTime()));
        permit.setRoomId(2);
        permit.setPatientId(1);
        permitHibernateDao.save(permit);
        assertEquals(permitHibernateDao.getAll(0, 10).size(), 3);
    }

    @Test
    public void testDelete() throws Exception {
        Permit permit = permitHibernateDao.get(1);
        assertNotNull(permit);
        permitHibernateDao.delete(permit);
        assertEquals(permitHibernateDao.getAll(0, 3).size(), 1);

    }

    @Test
    public void testGet() throws Exception {
        assertNotNull(permitHibernateDao.get(1));
    }

    @Test
    public void testGetAll() throws Exception {
        List<Permit> permits = permitHibernateDao.getAll(0, 2);
        assertFalse(permits.isEmpty());
        assertEquals(permits.size(), 2);
    }
}
