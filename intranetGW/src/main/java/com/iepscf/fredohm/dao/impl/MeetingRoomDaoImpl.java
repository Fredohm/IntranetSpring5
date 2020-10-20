package com.iepscf.fredohm.dao.impl;

import com.iepscf.fredohm.dao.MeetingRoomDao;
import com.iepscf.fredohm.entity.MeetingRoom;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MeetingRoomDaoImpl implements MeetingRoomDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public MeetingRoomDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<MeetingRoom> getMeetingRooms() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<MeetingRoom> query = currentSession.createQuery("from MeetingRoom ");

        return query.getResultList();
    }

    @Override
    public void saveMeetingRoom(MeetingRoom meetingRoom) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(meetingRoom);
    }

    @Override
    public MeetingRoom getMeetingRoom(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.get(MeetingRoom.class, id);
    }

    @Override
    public void deleteMeetingRoom(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("delete from MeetingRoom where id=:meetingRoomId");

        query.setParameter("meetingRoomId", id);

        query.executeUpdate();
    }
}
