package com.traveloka.calendar.org.calendar.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeetingController {

    @GetMapping("org/traveloka/calender/v1/meeting/create")
    public String testFirst(){

        return "hi";
    }

}
