package com.example.employee_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employee_service.Entity.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
