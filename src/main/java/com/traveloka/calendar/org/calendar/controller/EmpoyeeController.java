package com.traveloka.calendar.org.calendar.controller;


import com.traveloka.calendar.org.calendar.dto.Employee;
import com.traveloka.calendar.org.calendar.exceptions.ApplicationLevelException;
import com.traveloka.calendar.org.calendar.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpoyeeController {

    @Autowired
    EmployeeService employeeService;


    @PostMapping("org/traveloka/calender/v1/employee/create")
    public String createEmployee(@RequestBody Employee employee) throws ApplicationLevelException{

         if(employeeService.createEmployee(employee)){
             return "Employee Created Successfully." + employee;
         }
         else{
             throw new ApplicationLevelException("Problem while attempt operation");
         }
    }


}
