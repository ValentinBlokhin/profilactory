package com.profilactory.model.dao.hibernate;

import com.profilactory.model.dao.databasefilter.DataBaseFilter;
import com.profilactory.model.entity.CurrentPatient;
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
@ContextConfiguration(locations = "classpath:/dao/CurrentPatient/springconfig/currentpatient-hibernate-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class CurrentPatientHibernateDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;


    private CurrentPatientHibernateDao dao = new CurrentPatientHibernateDao();

    @Autowired
    private DataBaseFilter dataBaseFilter;

    @Before
    public void setUp() throws Exception {
        dao.setSessionFactory(sessionFactory);
        dataBaseFilter.fill();
    }

    @Test
    public void testSave() throws Exception {
        CurrentPatient currentPatient = new CurrentPatient();
        currentPatient.setCurrentPatientId(3);
        currentPatient.setDrugDiagnosisDiagnosisId(1);
        currentPatient.setDrugDiagnosisDrugId(1);
        currentPatient.setPatientId(1);
        dao.save(currentPatient);
        assertEquals(dao.getAll(0, 10).size(), 3);
    }

    @Test
    public void testDelete() throws Exception {
        CurrentPatient currentPatient = new CurrentPatient();
        currentPatient.setCurrentPatientId(3);
        currentPatient.setDrugDiagnosisDiagnosisId(1);
        currentPatient.setDrugDiagnosisDrugId(1);
        currentPatient.setPatientId(1);
        dao.save(currentPatient);
        assertEquals(dao.getAll(0, 10).size(), 3);
        dao.delete(currentPatient);
        assertEquals(dao.getAll(0, 10).size(), 2);
    }

    @Test
    public void testGet() throws Exception {
        CurrentPatient currentPatient = dao.get(1);
        assertNotNull(currentPatient);
    }

    @Test
    public void testGetAll() throws Exception {
        List<CurrentPatient> patients = dao.getAll(0, 10);
        assertEquals(patients.size(), 2);
    }
}
