package com.traveloka.calendar.org.calendar.controller;


import com.traveloka.calendar.org.calendar.dto.Employee;
import com.traveloka.calendar.org.calendar.dto.Meeting;
import com.traveloka.calendar.org.calendar.exceptions.ResourceNotFoundException;
import com.traveloka.calendar.org.calendar.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class ScheduleController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("org/traveloka/calender/v1/schedule/get/{id}")
    public Set<Meeting> getSchedule(@PathVariable String id) throws ResourceNotFoundException {

        Employee employee = employeeService.findEmployeeByID(id);
        if (employee != null) {
            return employee.getMeetings();
        } else {
            throw new ResourceNotFoundException("Not find any for the given id.");
        }

    }

}
