package com.blopa.demo.controllers;

import com.blopa.demo.entity.Employee;
import com.blopa.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/employee")
public class EmployeeCotroller {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addemployee")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        employeeService.AddEmployee(employee);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/getemployees")
    public ResponseEntity<?> getEmployees(){
        Collection<Employee> allEmployees = employeeService.getEMployees();
        return new ResponseEntity<>(allEmployees, HttpStatus.OK);
    }

    @PutMapping("/updateemployee/{employeeId}")
    public ResponseEntity<?> updateEmployee(@PathVariable Integer employeeId, @RequestBody Employee newEmployee){
        Employee employee = employeeService.updateEmployeById(newEmployee, employeeId);
        if(employee == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
