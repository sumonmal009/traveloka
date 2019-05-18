package com.traveloka.calendar.org.calendar.advice;


import com.traveloka.calendar.org.calendar.exceptions.ApplicationLevelException;
import com.traveloka.calendar.org.calendar.exceptions.ConflictException;
import com.traveloka.calendar.org.calendar.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandlerAdvice {




    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public String handleConflictException(HttpServletRequest request){

        return "Conflict Exception occured for the request "+request;

    }


    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handleResourceNotFoundException(HttpServletRequest request){

        return "ResourceNotFoundException occured for the request "+request;

    }



    @ExceptionHandler(ApplicationLevelException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handleApplicationLevelException(HttpServletRequest request){

        return "ApplicationLevelException occured for the request "+request;

    }

}
