package com.springboot.restapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.restapi.dto.RequestDTO;
import com.springboot.restapi.dto.ResponseDTO;

public interface EmployeeService {
	
	ResponseDTO createEmployee(RequestDTO dto);
	
	ResponseDTO getById(Integer id);
	
	Page<ResponseDTO> getAllEmployee(Pageable pageable);
	
	ResponseDTO updateEmployee(Integer id , RequestDTO requestDTO);
	
	void deleteEmployee(Integer id);
	
	
}
