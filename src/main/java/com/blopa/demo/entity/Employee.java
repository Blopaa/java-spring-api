package com.blopa.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"}, name = "UKemail")})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private int salary;
    private String role;
}
