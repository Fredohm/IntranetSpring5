package com.iepscf.fredohm.service;

import com.iepscf.fredohm.entity.MeetingRoom;

import java.util.List;

public interface MeetingRoomService {

    List<MeetingRoom> getMeetingRooms();

    MeetingRoom getMeetingRoom(int id);

    void saveMeetingRoom(MeetingRoom meetingRoom);

    void deleteMeetingRoom(int id);
}
