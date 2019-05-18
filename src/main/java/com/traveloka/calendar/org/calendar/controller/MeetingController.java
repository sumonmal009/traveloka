package com.traveloka.calendar.org.calendar.controller;


import com.traveloka.calendar.org.calendar.dto.Employee;
import com.traveloka.calendar.org.calendar.dto.Meeting;
import com.traveloka.calendar.org.calendar.repository.MeetingRepository;
import com.traveloka.calendar.org.calendar.service.InviteService;
import com.traveloka.calendar.org.calendar.service.MeetingService;
import com.traveloka.calendar.org.calendar.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MeetingController {

    @Autowired
    ValidationService validationService;

    @Autowired
    MeetingService meetingService;

    @Autowired
    InviteService inviteService;


    @GetMapping("org/traveloka/calender/v1/meeting/create")
    public String createMeeting(@RequestBody Meeting meeting){

        List<Employee> invalidInvitees = validationService.validateInvitee(meeting.getInvites());
        if(!invalidInvitees.isEmpty()){
            return "Invalid invitees present: "+invalidInvitees;
        }

        Meeting conflictedMeeting = meetingService.isConflict(meeting);
        if(conflictedMeeting!=null){
            return "Conflict with "+ conflictedMeeting;
        }

        meetingService.createMeeting(meeting);

        inviteService.sendRequestAllInvitees(meeting);

        return "Invite send to all invitees successfully";
    }

}
