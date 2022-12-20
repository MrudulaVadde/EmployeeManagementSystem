package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.entity.EmpOrgModel;
import com.example.EmployeeManagementSystem.entity.EmployeeModel;
import com.example.EmployeeManagementSystem.entity.OrganizationModel;
import com.example.EmployeeManagementSystem.entity.OrganizationModel;
import com.example.EmployeeManagementSystem.repository.EmployeeRepo;
import com.example.EmployeeManagementSystem.repository.OrganizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/organization")
@CrossOrigin(origins="*")
public class OrganizationController {

    @Autowired
    public OrganizationRepo organizationRepo;

    @Autowired
    public EmployeeRepo employeeRepo;

    @GetMapping("/all/details")
    public ResponseEntity<List<OrganizationModel>> getAllOrganizationDetails(@RequestParam Integer empId) {
        try {
            List<OrganizationModel> oganizationList = organizationRepo.findAllByEmployeeEmpId(empId);
            return Objects.nonNull(oganizationList) && oganizationList.size() > 0 ? ResponseEntity.ok(oganizationList) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/details")
    public ResponseEntity<Optional<OrganizationModel>> getOrganizationDetails(@RequestParam Integer empId, @RequestParam Integer orgId) {
        try {
            Optional<OrganizationModel> organizationData = organizationRepo.findByOrgIdAndEmployeeEmpId(orgId, empId);
            return Objects.nonNull(organizationData) ? ResponseEntity.ok(organizationData) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/details")
    public ResponseEntity<OrganizationModel> saveOrganizationDetails(@RequestBody EmpOrgModel requestPayload) {
        try {
            Integer empId = requestPayload.empId;
            Optional<EmployeeModel> details = employeeRepo.findById(empId);
            EmployeeModel empDetails = details.get();
            OrganizationModel orgDetails = requestPayload.organizationDetails;
            orgDetails.setEmployee(empDetails);
            OrganizationModel response = organizationRepo.save(orgDetails);
            return Objects.nonNull(response) ? ResponseEntity.ok(response) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/details")
    public ResponseEntity<OrganizationModel> updateOrganizationDetails(@RequestBody EmpOrgModel requestPayload) {
        try {
            Integer empId = requestPayload.empId;
            Optional<EmployeeModel> details = employeeRepo.findById(empId);
            EmployeeModel empDetails = details.get();
            OrganizationModel orgDetails = requestPayload.organizationDetails;
            orgDetails.setEmployee(empDetails);
            OrganizationModel response = organizationRepo.save(orgDetails);
            return Objects.nonNull(response) ? ResponseEntity.ok(response) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/details")
    public ResponseEntity<Boolean> deleteOrganizationDetails(@RequestParam Integer empId, @RequestParam Integer orgId) {
        try {
            organizationRepo.deleteOrganization(orgId, empId);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}

