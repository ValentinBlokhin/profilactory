package com.profilactory.model.dao.hibernate;

import com.profilactory.model.dao.databasefilter.DataBaseFilter;
import com.profilactory.model.entity.Diagnosis;
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
@ContextConfiguration(locations = "classpath:/dao/Diagnosis/springconfig/diagnosis-hibernate-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class DiagnosisHibernateDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    private DiagnosisHibernateDao diagnosisHibernateDao = new DiagnosisHibernateDao();

    @Autowired
    private DataBaseFilter dataBaseFilter;

    @Before
    public void setUp() throws Exception {
        diagnosisHibernateDao.setSessionFactory(sessionFactory);
        dataBaseFilter.fill();
    }

    @Test
    public void testSaveOrUpdate() throws Exception {
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setDiagnosisId(3);
        diagnosis.setName("oznob");
        diagnosisHibernateDao.saveOrUpdate(diagnosis);
        assertEquals(diagnosisHibernateDao.getAll(0, 10).size(), 3);
    }

    @Test
    public void testDelete() throws Exception {
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setDiagnosisId(3);
        diagnosis.setName("oznob");
        diagnosisHibernateDao.saveOrUpdate(diagnosis);
        assertEquals(diagnosisHibernateDao.getAll(0, 10).size(), 3);
        diagnosisHibernateDao.delete(diagnosis);
        assertEquals(diagnosisHibernateDao.getAll(0, 10).size(), 2);
    }

    @Test
    public void testGet() throws Exception {
        Diagnosis diagnosis = diagnosisHibernateDao.get(1);
        assertNotNull(diagnosis);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Diagnosis> diagnosises = diagnosisHibernateDao.getAll(0, 10);
        assertFalse(diagnosises.isEmpty());
    }
}
