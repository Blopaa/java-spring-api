package com.blopa.demo.services;

import com.blopa.demo.entity.Employee;
import com.blopa.demo.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public Object getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public Employee AddEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
