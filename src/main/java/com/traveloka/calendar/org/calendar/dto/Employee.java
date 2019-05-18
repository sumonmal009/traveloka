package com.traveloka.calendar.org.calendar.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Employee {

    private String empId;
    private String name;
    private Set<Meeting> meetings = new HashSet<>();

    public Employee(String empId, String name) {
        this.empId = empId;
        this.name = name;
    }


    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeeting(Meeting meetings) {
        this.meetings.add(meetings);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return empId.equals(employee.empId) &&
                name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, name);
    }


    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", meetings=" + meetings +
                '}';
    }
}
