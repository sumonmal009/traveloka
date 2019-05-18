package com.traveloka.calendar.org.calendar.service;

import com.traveloka.calendar.org.calendar.dto.Meeting;
import com.traveloka.calendar.org.calendar.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MeetingService {
    @Autowired
    MeetingRepository meetingRepository;

    public Meeting isConflict(Meeting requestedMeeting){

        for (Meeting meeting : meetingRepository.getMeetings()
                ) {
            if(meeting.conflict(requestedMeeting)){
                return meeting;
            }

        }

       return null;
    }


    public void createMeeting(Meeting requestedMeeting){

         meetingRepository.addMeeting(requestedMeeting);

    }



}
