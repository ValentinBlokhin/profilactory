package com.profilactory.model.dao.hibernate;

import com.profilactory.model.dao.databasefilter.DataBaseFilter;
import com.profilactory.model.entity.Drug;
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
@ContextConfiguration(locations = "classpath:/dao/Drug/springconfig/drug-hibernate-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class DrugHibernateDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    private DrugHibernateDao drugHibernateDao = new DrugHibernateDao();

    @Autowired
    private DataBaseFilter dataBaseFilter;

    @Before
    public void setUp() throws Exception {
        drugHibernateDao.setSessionFactory(sessionFactory);
        dataBaseFilter.fill();
    }

    @Test
    public void testSave() throws Exception {
        Drug drug = new Drug();
        drug.setDrugId(3);
        drug.setName("pikovit");
        drug.setType("vitamins");
        drugHibernateDao.save(drug);
        assertEquals(drugHibernateDao.getAll(0, 10).size(), 3);
    }

    @Test
    public void testDelete() throws Exception {
        Drug drug = new Drug();
        drug.setDrugId(3);
        drug.setName("pikovit");
        drug.setType("vitamins");
        drugHibernateDao.save(drug);
        assertEquals(drugHibernateDao.getAll(0, 10).size(), 3);
        drugHibernateDao.delete(drug);
        assertEquals(drugHibernateDao.getAll(0, 10).size(), 2);
    }

    @Test
    public void testGet() throws Exception {
        Drug drug = drugHibernateDao.get(1);
        assertNotNull(drug);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Drug> drugs = drugHibernateDao.getAll(0, 10);
        assertFalse(drugs.isEmpty());
    }
}
