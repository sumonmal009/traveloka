package com.traveloka.calendar.org.calendar.dto;



import java.sql.Time;
import java.util.*;


public class Meeting {

    private String meetingID;
    private String subject;
    private Time startTime;
    private Time endTime;
    private String roomName;
    Set<Employee> invites = new HashSet<Employee>();

    public Meeting(String meetingID, String subject, Time startTime, Time endTime, String roomName, Set<Employee> invites) {
        this.meetingID = meetingID;
        this.subject = subject;
        this.startTime = startTime;
        this.endTime = endTime;
        this.roomName = roomName;
        this.invites = invites;
    }

    public String getMeetingID() {
        return meetingID;
    }

    public void setMeetingID(String meetingID) {
        this.meetingID = meetingID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }


    public Set<Employee> getInvites() {
        return invites;
    }

    public void setInvites(Set<Employee> invites) {
        this.invites.addAll(invites);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meeting)) return false;
        Meeting meeting = (Meeting) o;
        return meetingID.equals(meeting.meetingID) &&
                startTime.equals(meeting.startTime) &&
                endTime.equals(meeting.endTime) &&
                Objects.equals(roomName, meeting.roomName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meetingID, startTime, endTime, roomName);
    }


    public boolean conflict(Object o) { // detect conflict
        if (this == o) return true;
        if (!(o instanceof Meeting)) return false;
        Meeting meeting = (Meeting) o;
        return startTime.equals(meeting.startTime) &&
                endTime.equals(meeting.endTime) &&
                Objects.equals(roomName, meeting.roomName);
    }


    @Override
    public String toString() {
        return "Meeting{" +
                "meetingID='" + meetingID + '\'' +
                ", subject='" + subject + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", roomName='" + roomName + '\'' +
                ", invites=" + invites +
                '}';
    }
}
