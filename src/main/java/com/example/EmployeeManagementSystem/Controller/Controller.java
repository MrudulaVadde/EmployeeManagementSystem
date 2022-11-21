package com.example.EmployeeManagementSystem.Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.EmployeeManagementSystem.repository.OrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeManagementSystem.Entity.*;

	@RestController
	@CrossOrigin(origins="*")
	public class Controller {

		@Autowired
		public OrganizationRepo orgRepo;

		@GetMapping("Employees")
		public List<Organization> getEmployeeDetails(){
			
//			return Stream.of(new Employee(1, "ABC", "M", "abc@gmail.com", 1234, 20000.0),
//					new Employee(2, "BCD", "F", "bcd@gmail.com", 2345, 22000.0),
//					new Employee(4, "CDE", "M", "cde@gmail.com", 3456, 24000.0)).collect(Collectors.toList());
		Employee emp1 = new Employee();
		emp1.setEmpId(1);
		emp1.setEmpname("ABC");
		emp1.setGender("M");
		emp1.setEmpEmail("abc@gmail.com");
		emp1.setSalary(10000);

		Organization org1 = new Organization();
		org1.orgId=1;
		org1.orgName="Accenture";
		org1.employee=emp1;

		Organization org2=new Organization();
		org2.orgId=2;
		org2.orgName="Capgemini";
		org2.employee=emp1;

		List<Organization> list=new ArrayList();

		list.add(org1);
		list.add(org2);

		return orgRepo.saveAll(list);

	}

		@GetMapping("orgdetails/{id}")
		public Organization getUserDetails(@PathVariable int id){
			return orgRepo.findById(id).get();
		}
}

