package com.sutanu.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sutanu.main.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
