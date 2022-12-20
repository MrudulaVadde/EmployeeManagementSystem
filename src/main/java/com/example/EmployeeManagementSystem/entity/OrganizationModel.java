package com.example.EmployeeManagementSystem.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@ToString
@Table(name = "organizationdetails")
public class OrganizationModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "org_id")
    public Integer orgId;

    @Column(name = "org_name")
    public String orgName;

    @Column(name = "org_type")
    public String orgType;

    @Column(name = "org_location")
    public String orgLocation;
    @ManyToOne(cascade = {CascadeType.ALL})
    @NotFound(action = NotFoundAction.IGNORE)
    public EmployeeModel employee;



}
