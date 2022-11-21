package com.example.EmployeeManagementSystem.Entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Organization {

    @Id
    public int orgId;

    public String orgName;

    @ManyToOne(cascade = {CascadeType.ALL})
    @NotFound(action = NotFoundAction.IGNORE)
    public Employee employee;



}
