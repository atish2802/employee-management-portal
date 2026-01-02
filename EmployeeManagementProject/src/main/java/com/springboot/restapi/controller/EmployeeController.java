package com.springboot.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restapi.dto.RequestDTO;
import com.springboot.restapi.dto.ResponseDTO;
import com.springboot.restapi.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseDTO createEmployee( @Valid @RequestBody RequestDTO dto) {
		
		return employeeService.createEmployee(dto);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseDTO getById(@PathVariable Integer id) {
		
		ResponseDTO byId = employeeService.getById(id);
		return byId;
	}
	
	@GetMapping("/employee")
	public Page<ResponseDTO> getAllEmployee(
		@PageableDefault(size = 5)	Pageable pageable){
		Page<ResponseDTO> allEmployee = employeeService.getAllEmployee(pageable);
		return allEmployee;
	}
	
	@PutMapping("/employee/{id}")
	public ResponseDTO updateEmployee(@PathVariable Integer id , @RequestBody RequestDTO dto) {
			
		ResponseDTO updateEmployee = employeeService.updateEmployee(id, dto);
		
		return updateEmployee;
	}
	
	public void deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployee(id);
		
	}
	
}
