package com.traveloka.calendar.org.calendar.repository;


import com.traveloka.calendar.org.calendar.dto.Meeting;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class MeetingRepository {

    private static final Set<Meeting> meetingRepo = new HashSet<Meeting>();

    public Set<Meeting> getMeetings() {
        return meetingRepo;
    }

    public void addMeeting(Meeting meeting) {
        MeetingRepository.meetingRepo.add(meeting);
    }
}
