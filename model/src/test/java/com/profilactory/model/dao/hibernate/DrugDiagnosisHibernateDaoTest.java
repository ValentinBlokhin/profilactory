package com.profilactory.model.dao.hibernate;

import com.profilactory.model.dao.databasefilter.DataBaseFilter;
import com.profilactory.model.entity.DrugDiagnosis;
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
 * Created by ValentinBlokhin on 4/2/2014.
 */
@ContextConfiguration(locations = "classpath:dao/DrugDiagnosis/springconfig/drug-diagnosis-hibernate-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class DrugDiagnosisHibernateDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;


    private DrugDiagnosisHibernateDao dao = new DrugDiagnosisHibernateDao();

    @Autowired
    private DataBaseFilter dataBaseFilter;

    @Before
    public void setUp() throws Exception {
        dao.setSessionFactory(sessionFactory);
        dataBaseFilter.fill();
    }

    @Test
    public void testSave() throws Exception {
        DrugDiagnosis drugDiagnosis = new DrugDiagnosis();
        drugDiagnosis.setIdDiagnosis(2);
        drugDiagnosis.setIdDrug(2);
        dao.save(drugDiagnosis);
        assertEquals(dao.getAll(0, 10).size(), 3);
    }

    @Test
    public void testDelete() throws Exception {
        DrugDiagnosis drugDiagnosis = new DrugDiagnosis();
        drugDiagnosis.setIdDiagnosis(2);
        drugDiagnosis.setIdDrug(2);
        dao.save(drugDiagnosis);
        assertEquals(dao.getAll(0, 10).size(), 3);
        dao.delete(drugDiagnosis);
        assertEquals(dao.getAll(0, 10).size(), 2);
    }

    @Test
    public void testGet() throws Exception {
        DrugDiagnosis drugDiagnosis = dao.get(1);
        assertEquals(drugDiagnosis.getIdDiagnosis(), 1);
    }

    @Test
    public void testGetPK() throws Exception {
        DrugDiagnosis drugDiagnosis = dao.getPK(1, 2);
        assertNotNull(drugDiagnosis);
    }

    @Test
    public void testGetAll() throws Exception {
        List<DrugDiagnosis> drugDiagnosises = dao.getAll(0, 10);
        assertEquals(drugDiagnosises.size(), 2);
    }
}
