package com.resttemplate.employee.service;

import com.resttemplate.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    public List<Employee> allEmployees() {
        List<Employee> employeeList = List.of(new Employee(1L, "atif"), new Employee(2L, "uttam"));
        return employeeList.stream().collect(Collectors.toList());
    }

    public void addEmployee(Employee employee) {
        Employee employee1 = new Employee();
        employee1.setEmployeeId(employee.getEmployeeId());
        employee1.setEmployeeName(employee.getEmployeeName());
    }
}
