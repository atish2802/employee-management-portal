package com.springboot.restapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restapi.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	List<Employee> findByNameContaining(String name);

	Optional<Employee> findByEmail(String email);

	List<Employee> findByDepartmentContaining(String department);

	List<Employee> findBySalary(Double salary);

}
