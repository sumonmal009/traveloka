package com.traveloka.calendar.org.calendar.service;

import com.traveloka.calendar.org.calendar.dto.Employee;
import com.traveloka.calendar.org.calendar.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public boolean createEmployee(Employee employee){
        return employeeRepository.addEmployee(employee);

    }

    public Employee findEmployeeByID(String id){

        if(StringUtils.isEmpty(id)){
            return null;
        }

        for (Employee employee:  employeeRepository.getEmployees()
             ) {
            if(employee.getEmpId().equals(id))
                return employee;
        }
        return null;
    }

}
