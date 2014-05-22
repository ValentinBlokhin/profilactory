package com.profilactory.model.dao.hibernate;

import com.profilactory.model.dao.databasefilter.DataBaseFilter;
import com.profilactory.model.entity.Procedure;
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
 * Created by ValentinBlokhin on 4/2/2014.
 */
@ContextConfiguration(locations = "classpath:/dao/Procedure/springconfig/procedure-hibernate-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class ProcedureHibernateDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    private ProcedureHibernateDao procedureHibernateDao = new ProcedureHibernateDao();

    @Autowired
    private DataBaseFilter dataBaseFilter;

    @Before
    public void setUp() throws Exception {
        procedureHibernateDao.setSessionFactory(sessionFactory);
        dataBaseFilter.fill();
    }

    @Test
    public void testSave() throws Exception {
        Procedure procedure = new Procedure();
        procedure.setProcedureId(3);
        procedure.setName("Massage");
        procedure.setPurpose("for like");
        procedureHibernateDao.save(procedure);
        assertEquals(procedureHibernateDao.getAll(0, 10).size(), 3);
    }

    @Test
    public void testDelete() throws Exception {
        Procedure procedure = new Procedure();
        procedure.setProcedureId(3);
        procedure.setName("Massage");
        procedure.setPurpose("for like");
        procedureHibernateDao.save(procedure);
        assertEquals(procedureHibernateDao.getAll(0, 10).size(), 3);
        procedureHibernateDao.delete(procedure);
        assertEquals(procedureHibernateDao.getAll(0, 10).size(), 2);
    }

    @Test
    public void testGet() throws Exception {
        Procedure procedure = procedureHibernateDao.get(1);
        assertNotNull(procedure);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Procedure> list = procedureHibernateDao.getAll(0, 10);
        assertFalse(list.isEmpty());
    }
}
