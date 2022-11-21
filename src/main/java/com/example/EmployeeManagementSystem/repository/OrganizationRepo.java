package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.Entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepo extends JpaRepository<Organization,Integer> {
}
