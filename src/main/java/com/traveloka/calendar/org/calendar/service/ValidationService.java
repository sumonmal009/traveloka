package com.traveloka.calendar.org.calendar.service;


import com.traveloka.calendar.org.calendar.dto.Employee;
import com.traveloka.calendar.org.calendar.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class ValidationService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private List<Employee> invalidInvitees = new LinkedList<>();

    public List<Employee> validateInvitee(Set<Employee> employees){
        for (Employee employee: employees
             ) {
            if(!employeeRepository.getEmployees().contains(employee)){
                invalidInvitees.add(employee);
            }

        }
            return invalidInvitees;
    }
}
