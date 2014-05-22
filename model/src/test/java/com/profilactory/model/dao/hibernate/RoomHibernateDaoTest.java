package com.profilactory.model.dao.hibernate;

import com.profilactory.model.dao.databasefilter.DataBaseFilter;
import com.profilactory.model.entity.Room;
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

import javax.sql.DataSource;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ValentinBlokhin on 3/28/2014.
 */
@ContextConfiguration(locations = "classpath*:/dao/Room/springconfig/room-hibernate-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class RoomHibernateDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    private RoomHibernateDao roomHibernateDao = new RoomHibernateDao();

    @Autowired(required = true)
    @Qualifier("sessionFactory")
    private SessionFactory sessionFactory;

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Autowired
    @Qualifier("dbFilter")
    private DataBaseFilter dataBaseFilter;


    @Before
    public void setUp() throws Exception {
        roomHibernateDao.setSessionFactory(sessionFactory);
        dataBaseFilter.fill();
    }

    @Test
    public void testSave() throws Exception {
        Room room = new Room();
        room.setRoomId(3);
        room.setRoomNumber(315);
        room.setSeats(2);
        room.setBusySeats(3);

        roomHibernateDao.save(room);
        assertNotNull(roomHibernateDao.get(3));
        assertEquals(room, roomHibernateDao.get(3));
    }

    @Test
    public void testDelete() throws Exception {
        Room room = new Room();
        room.setSeats(4);
        room.setRoomNumber(315);
        room.setRoomId(3);
        room.setBusySeats(3);
        roomHibernateDao.save(room);
        assertEquals(roomHibernateDao.get(3), room);
        roomHibernateDao.delete(room);
        assertEquals(roomHibernateDao.getAll(0, 2).size(), 2);
    }

    @Test
    public void testGet() throws Exception {
        Room room = roomHibernateDao.get(1);
        assertNotNull(room);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Room> rooms = roomHibernateDao.getAll(0, 2);
        assertFalse(rooms.isEmpty());
    }
}
