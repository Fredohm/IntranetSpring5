package com.iepscf.fredohm.entity;

import javax.persistence.*;

@Entity
@Table(name = "meeting_room")
public class MeetingRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "meeting_room_name")
    private String meetingRoomName;

    @Column(name = "meeting_room_places_nb")
    private int meetingRoomPlacesNb;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    @Column(name = "available")
    private boolean available;

    public MeetingRoom() {
    }

    public MeetingRoom(String meetingRoomName, int meetingRoomPlacesNb, String location, String description, boolean available) {
        this.meetingRoomName = meetingRoomName;
        this.meetingRoomPlacesNb = meetingRoomPlacesNb;
        this.location = location;
        this.description = description;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeetingRoomName() {
        return meetingRoomName;
    }

    public void setMeetingRoomName(String meetingRoomName) {
        this.meetingRoomName = meetingRoomName;
    }

    public int getMeetingRoomPlacesNb() {
        return meetingRoomPlacesNb;
    }

    public void setMeetingRoomPlacesNb(int meetingRoomPlacesNb) {
        this.meetingRoomPlacesNb = meetingRoomPlacesNb;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "MeetingRoom{" +
                "id=" + id +
                ", meetingRoomName='" + meetingRoomName + '\'' +
                ", meetingRoomPlacesNb=" + meetingRoomPlacesNb +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                '}';
    }
}
