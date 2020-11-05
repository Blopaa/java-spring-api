package com.blopa.demo.services;

import com.blopa.demo.entity.Employee;
import com.blopa.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Object getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public List<Employee> getEMployees(){
        return (List<Employee>) employeeRepository.findAll();
    }

    public void AddEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
