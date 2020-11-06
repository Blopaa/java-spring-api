package com.blopa.demo.services;

import com.blopa.demo.entity.Employee;
import com.blopa.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    public List<Employee> getEMployees(){
        return employeeRepository.findAll();
    }

    public void AddEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee updateEmployeById(Employee employee, Integer ID){
        Employee existsEmploye = employeeRepository.findById(ID).orElse(null);
        if(existsEmploye == null) return null;
        existsEmploye.setName(employee.getName());
        existsEmploye.setEmail(employee.getEmail());
        existsEmploye.setSalary(employee.getSalary());
        return employeeRepository.save(existsEmploye);
    }

    public String deleteEmployeById(Integer ID){
        Employee existsEmploye = employeeRepository.findById(ID).orElse(null);
        if(existsEmploye == null) return null;
        employeeRepository.deleteById(ID);
        return "Employe removed :(";
    }
}
