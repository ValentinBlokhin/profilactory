package com.profilactory.model.dao.hibernate;

import com.profilactory.model.dao.databasefilter.DataBaseFilter;
import com.profilactory.model.entity.Cabinet;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ValentinBlokhin on 4/3/2014.
 */
@ContextConfiguration(locations = "classpath:dao/Cabinet/springconfig/cabinet-hibernate-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class CabinetHibernateDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;


    private CabinetHibernateDao dao = new CabinetHibernateDao();

    @Autowired
    private DataBaseFilter dataBaseFilter;

    @Before
    public void setUp() throws Exception {
        dao.setSessionFactory(sessionFactory);
        dataBaseFilter.fill();
    }

    @Test
    public void testSaveOrUpdate() throws Exception {
        Cabinet cabinet = new Cabinet();
        cabinet.setName("test3");
        cabinet.setCabinetId(3);
        cabinet.setPersonalId(2);
        dao.saveOrUpdate(cabinet);
        assertEquals(dao.getAll(0, 10).size(), 3);
    }

    @Test
    public void testDelete() throws Exception {
        Cabinet cabinet = new Cabinet();
        cabinet.setName("test3");
        cabinet.setCabinetId(3);
        cabinet.setPersonalId(2);
        dao.saveOrUpdate(cabinet);
        assertEquals(dao.getAll(0, 10).size(), 3);
        dao.delete(cabinet);
        assertEquals(dao.getAll(0, 10).size(), 2);
    }

    @Test
    public void testGet() throws Exception {
        Cabinet cabinet = dao.get(1);
        assertNotNull(cabinet);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Cabinet> cabinets = dao.getAll(0, 10);
        assertNotNull(cabinets);
    }
}
