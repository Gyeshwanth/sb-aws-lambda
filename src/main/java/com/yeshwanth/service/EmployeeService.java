package com.yeshwanth.service;

import com.yeshwanth.dto.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();


    //wite method to add employee and get all employees

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployee(String id) {
        return employees.stream().filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
    }

    public Employee updateEmployee(String id, Employee employee) {
        Employee emp = employees.stream().filter(e -> e.getId().equals(id)).findFirst().orElseThrow(()-> new IllegalArgumentException("Employee not found for id: " + id));
        if (emp != null) {
            emp.setName(employee.getName());
            emp.setDesignation(employee.getDesignation());
            emp.setEmail(employee.getEmail());
        }
        return emp;
    }

    public void deleteEmployee(String id) {
        employees.removeIf(employee -> employee.getId().equals(id));
    }

}
