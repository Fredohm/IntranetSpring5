package com.iepscf.fredohm.dao;

import com.iepscf.fredohm.entity.MeetingRoom;

import java.util.List;

public interface MeetingRoomDao {

    List<MeetingRoom> getMeetingRooms();

    void saveMeetingRoom(MeetingRoom meetingRoom);

    MeetingRoom getMeetingRoom(int id);

    void deleteMeetingRoom(int id);
}
