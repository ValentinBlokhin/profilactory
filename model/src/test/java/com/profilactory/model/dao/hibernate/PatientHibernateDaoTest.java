package com.profilactory.model.dao.hibernate;

import com.profilactory.model.dao.databasefilter.DataBaseFilter;
import com.profilactory.model.entity.Patient;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ValentinBlokhin on 4/2/2014.
 */
@ContextConfiguration(locations = "classpath:/dao/Patient/springconfig/patient-hibernate-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class PatientHibernateDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    private PatientHibernateDao dao = new PatientHibernateDao();

    @Autowired
    private DataBaseFilter dataBaseFilter;

    @Before
    public void setUp() throws Exception {
        dao.setSessionFactory(sessionFactory);
        dataBaseFilter.fill();
    }

    @Test
    public void testSaveOrUpdate() throws Exception {
        Patient patient = new Patient();
        patient.setPatientId(3);
        patient.setFirstName("Aleksandr");
        patient.setSecondName("Kulakov");
        patient.setMiddleName("Petrovich");
        patient.setStudentId(55593345);
        patient.setPermitId(1);
        dao.saveOrUpdate(patient);
        assertEquals(dao.getAll(0, 10).size(), 3);
    }

    @Test
    public void testDelete() throws Exception {
        Patient patient = new Patient();
        patient.setPatientId(3);
        patient.setFirstName("Aleksandr");
        patient.setSecondName("Kulakov");
        patient.setMiddleName("Petrovich");
        patient.setStudentId(55593345);
        patient.setPermitId(1);
        dao.saveOrUpdate(patient);
        assertEquals(dao.getAll(0, 10).size(), 3);
        dao.delete(patient);
        assertEquals(dao.getAll(0, 10).size(), 2);
    }

    @Test
    public void testGet() throws Exception {
        Patient patient = dao.get(1);
        assertNotNull(patient);
    }

    @Test
    public void testGetAll() throws Exception {
        assertEquals(dao.getAll(0, 10).size(), 2);
    }
}
