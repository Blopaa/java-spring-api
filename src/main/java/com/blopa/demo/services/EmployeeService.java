package com.blopa.demo.services;

import com.blopa.demo.entity.Employee;
import com.blopa.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
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

    public Employee updateEmployeById(Employee employee, Integer ID){
        Employee existsEmploye = (Employee) employeeRepository.findById(ID).orElse(null);
        if(existsEmploye == null) return (Employee) null;
        existsEmploye.setName(employee.getName());
        existsEmploye.setEmail(employee.getEmail());
        existsEmploye.setSalary(employee.getSalary());
        return (Employee) employeeRepository.save(existsEmploye);
    }

    public String deleteEmployeById(Integer ID){
        Employee existsEmploye = (Employee) employeeRepository.findById(ID).orElse(null);
        if(existsEmploye == null) return (String) null;
        employeeRepository.deleteById(ID);
        return "Employe removed :(";
    }
}
