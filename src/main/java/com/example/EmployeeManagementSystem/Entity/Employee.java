package com.example.EmployeeManagementSystem.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	private int empId;
	private String empname;
	private String gender;
	private String empEmail;
	private int empPhone;
	private double salary;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public int getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(int empPhone) {
		this.empPhone = empPhone;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
//	public Employee(int empId, String empname, String gender, String empEmail, int empPhone, double salary) {
//		super();
//		this.empId = empId;
//		this.empname = empname;
//		this.gender = gender;
//		this.empEmail = empEmail;
//		this.empPhone = empPhone;
//		this.salary = salary;
//	}
	
	
}
