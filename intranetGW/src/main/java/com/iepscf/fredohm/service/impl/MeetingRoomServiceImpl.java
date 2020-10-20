package com.iepscf.fredohm.service.impl;

import com.iepscf.fredohm.dao.MeetingRoomDao;
import com.iepscf.fredohm.entity.MeetingRoom;
import com.iepscf.fredohm.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MeetingRoomServiceImpl implements MeetingRoomService {

    private final MeetingRoomDao meetingRoomDao;

    @Autowired
    public MeetingRoomServiceImpl(MeetingRoomDao meetingRoomDao) {
        this.meetingRoomDao = meetingRoomDao;
    }

    @Override
    @Transactional
    public List<MeetingRoom> getMeetingRooms() {
        return meetingRoomDao.getMeetingRooms();
    }

    @Override
    @Transactional
    public MeetingRoom getMeetingRoom(int id) {
        return meetingRoomDao.getMeetingRoom(id);
    }

    @Override
    @Transactional
    public void saveMeetingRoom(MeetingRoom meetingRoom) {
        meetingRoomDao.saveMeetingRoom(meetingRoom);
    }

    @Override
    @Transactional
    public void deleteMeetingRoom(int id) {
        meetingRoomDao.deleteMeetingRoom(id);
    }
}
