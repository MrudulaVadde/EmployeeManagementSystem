package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.entity.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeModel,Integer> {
}
