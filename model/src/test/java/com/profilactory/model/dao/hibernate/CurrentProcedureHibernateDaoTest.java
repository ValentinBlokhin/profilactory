package com.profilactory.model.dao.hibernate;

import com.profilactory.model.dao.databasefilter.DataBaseFilter;
import com.profilactory.model.entity.CurrentProcedure;
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
@ContextConfiguration(locations = "classpath:/dao/CurrentProcedure/springconfig/currentprocedure-hibernate-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class CurrentProcedureHibernateDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    private CurrentProcedureHibernateDao dao = new CurrentProcedureHibernateDao();

    @Autowired
    private DataBaseFilter dataBaseFilter;

    @Before
    public void setUp() throws Exception {
        dao.setSessionFactory(sessionFactory);
        dataBaseFilter.fill();
    }

    @Test
    public void testSaveOrUpdate() throws Exception {
        CurrentProcedure procedure = new CurrentProcedure();
        procedure.setCurrentProcedureId(3);
        procedure.setProcedureId(1);
        procedure.setPatientId(1);
        procedure.setCabinetId(1);
        procedure.setStatus("passed");
        dao.saveOrUpdate(procedure);
        assertEquals(dao.getAll(0, 10).size(), 3);
    }

    @Test
    public void testDelete() throws Exception {
        CurrentProcedure procedure = new CurrentProcedure();
        procedure.setPatientId(1);
        procedure.setCurrentProcedureId(3);
        procedure.setCabinetId(1);
        procedure.setStatus("passed");
        procedure.setProcedureId(1);
        dao.saveOrUpdate(procedure);
        assertEquals(dao.getAll(0, 10).size(), 3);
        dao.delete(procedure);
        assertEquals(dao.getAll(0, 10).size(), 2);
    }

    @Test
    public void testGet() throws Exception {
        CurrentProcedure currentProcedure = dao.get(1);
        assertNotNull(currentProcedure);
    }

    @Test
    public void testGetAll() throws Exception {
        List<CurrentProcedure> procedures = dao.getAll(0, 10);
        assertEquals(procedures.size(), 2);
    }
}
