package com.example.EmployeeManagementSystem.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.example.EmployeeManagementSystem.repository.EmployeeRepo;
import com.example.EmployeeManagementSystem.repository.OrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.EmployeeManagementSystem.entity.*;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    public EmployeeRepo employeeRepo;

	@Autowired
	public OrganizationRepo organizationRepo;

	@GetMapping("/all/details")
	public ResponseEntity<List<EmployeeModel>> getAllEmployeeDetails() {
		try {
			List<EmployeeModel> employeeList = employeeRepo.findAll();
			return Objects.nonNull(employeeList) && employeeList.size() > 0 ? ResponseEntity.ok(employeeList) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/details")
	public ResponseEntity<Optional<EmployeeModel>> getEmployeeDetails(@RequestParam Integer empId) {
		try {
			Optional<EmployeeModel> employeeData = employeeRepo.findById(empId);
			return Objects.nonNull(employeeData) ? ResponseEntity.ok(employeeData) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

    @PostMapping("/details")
    public ResponseEntity<EmployeeModel> saveEmployeeDetails(@RequestBody EmployeeModel employeeDetails) {
        try {
			EmployeeModel saveModel = new EmployeeModel();
			saveModel.setEmpId(null);
			saveModel.setEmpName(employeeDetails.getEmpName());
			saveModel.setGender(employeeDetails.getGender());
			saveModel.setSalary(employeeDetails.getSalary());
			saveModel.setEmpEmail(employeeDetails.getEmpEmail());
			saveModel.setEmpPhone(employeeDetails.getEmpPhone());
            EmployeeModel response = employeeRepo.save(saveModel);
            return Objects.nonNull(response) ? ResponseEntity.ok(response) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

	@PutMapping("/details")
	public ResponseEntity<EmployeeModel> updateEmployeeDetails(@RequestBody EmployeeModel employeeDetails) {
		try {
			EmployeeModel response = employeeRepo.save(employeeDetails);
			return Objects.nonNull(response) ? ResponseEntity.ok(response) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping("/details")
	public ResponseEntity<Boolean> deleteEmployeeDetails(@RequestParam Integer empId) {
		try {
			organizationRepo.deleteAllByEmployeeEmpId(empId);
			employeeRepo.deleteById(empId);
			return ResponseEntity.ok(true);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

}

