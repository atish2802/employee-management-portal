package com.springboot.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restapi.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
