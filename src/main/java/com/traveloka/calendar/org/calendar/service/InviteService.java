package com.traveloka.calendar.org.calendar.service;

import com.traveloka.calendar.org.calendar.dto.Employee;
import com.traveloka.calendar.org.calendar.dto.Meeting;
import com.traveloka.calendar.org.calendar.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InviteService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void sendRequestAllInvitees(Meeting meeting){

        for (Employee employee: meeting.getInvites()
             ) {
                employee.setMeeting(meeting);
        }

        }
    }

