package com.iepscf.fredohm.controller;

import com.iepscf.fredohm.entity.MeetingRoom;
import com.iepscf.fredohm.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/meeting-room")
public class RoomController {

    private final MeetingRoomService meetingRoomService;

    @Autowired
    public RoomController(MeetingRoomService meetingRoomService) {
        this.meetingRoomService = meetingRoomService;
    }

    @GetMapping("/list")
    public String listMeetingRooms(Model model) {

        List<MeetingRoom> rooms = meetingRoomService.getMeetingRooms();

        model.addAttribute("rooms", rooms);

        return "meeting-room-list";
    }

    @GetMapping("/display")
    public String showMeetingRoom(int id, Model model) {

        MeetingRoom meetingRoom = meetingRoomService.getMeetingRoom(id);

        model.addAttribute("meetingRoom", meetingRoom);

        return "meeting-room-display";
    }

    @GetMapping("/add")
    public String showFormForAdd(Model model) {

        MeetingRoom meetingRoom = new MeetingRoom();

        model.addAttribute("meetingRoom", meetingRoom);

        return "meeting-room-form";
    }

    @PostMapping("/save")
    public String saveMeetingRoom(@ModelAttribute("meetingRoom") MeetingRoom meetingRoom) {

        meetingRoomService.saveMeetingRoom(meetingRoom);

        return "redirect:/meeting-room/list";
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("meetingRoomId") int id, Model model) {

        MeetingRoom meetingRoom = meetingRoomService.getMeetingRoom(id);

        model.addAttribute("meetingRoom", meetingRoom);

        return "meeting-room-form";
    }

    @GetMapping("/delete")
    public String deleteMeetingRoom(@RequestParam("meetingRoomId") int id) {

        meetingRoomService.deleteMeetingRoom(id);

        return "redirect:/meeting-room/list";
    }

}
