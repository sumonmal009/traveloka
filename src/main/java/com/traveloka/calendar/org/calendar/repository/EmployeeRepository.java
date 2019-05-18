package com.traveloka.calendar.org.calendar.repository;


import com.traveloka.calendar.org.calendar.dto.Employee;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class EmployeeRepository {

    private static final Set<Employee> employeeRepo = new HashSet<Employee>();


    public boolean addEmployee(Employee employee){
           return employeeRepo.add(employee);
    }


    public boolean addEmployees(Set<Employee> employee){
        return employeeRepo.addAll(employee);
    }

    public  Set<Employee> getEmployees() {
        return employeeRepo;
    }
}
