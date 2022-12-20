package com.example.EmployeeManagementSystem.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@ToString
@Table(name = "employeedetails")
public class EmployeeModel {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "emp_id")
	private Integer empId;
	@Column(name = "emp_name")
	private String empName;
	@Column(name = "gender")
	private String gender;
	@Column(name = "emp_email")
	private String empEmail;
	@Column(name = "emp_phone")
	private Long empPhone;
	@Column(name = "salary")
	private Double salary;
}
