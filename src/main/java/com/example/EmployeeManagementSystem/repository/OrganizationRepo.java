package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.OrganizationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizationRepo extends JpaRepository<OrganizationModel,Integer> {

    List<OrganizationModel> findAllByEmployeeEmpId(Integer empId);

    Optional<OrganizationModel> findByOrgIdAndEmployeeEmpId(Integer orgId, Integer empId);

    @Modifying
    @Transactional
    @Query(value = "delete from employeemanagment.organizationdetails where employee_emp_id = ?1", nativeQuery = true)
    void deleteAllByEmployeeEmpId(Integer empId);

    @Modifying
    @Transactional
    @Query(value = "delete from employeemanagment.organizationdetails where org_id = ?1 and employee_emp_id = ?2", nativeQuery = true)
    void deleteOrganization(Integer orgId, Integer empId);
}
