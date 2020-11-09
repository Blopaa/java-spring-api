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

    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public List<Employee> getEMployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployeById(Employee employee, Integer id) {
        Employee existsEmploye = employeeRepository.findById(id).orElse(null);
        if (existsEmploye == null) return null;
        existsEmploye.setName(employee.getName());
        existsEmploye.setEmail(employee.getEmail());
        existsEmploye.setSalary(employee.getSalary());
        return employeeRepository.save(existsEmploye);
    }

    public String deleteEmployeById(Integer id) {
        Employee existsEmploye = employeeRepository.findById(id).orElse(null);
        if (existsEmploye == null) return null;
        employeeRepository.deleteById(id);
        return "Employe removed :(";
    }
}
