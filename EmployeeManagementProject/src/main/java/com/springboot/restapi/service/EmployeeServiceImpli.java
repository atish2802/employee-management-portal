package com.springboot.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.restapi.dto.RequestDTO;
import com.springboot.restapi.dto.ResponseDTO;
import com.springboot.restapi.entity.Employee;
import com.springboot.restapi.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpli implements EmployeeService {
	
	@Autowired
	private EmployeeRepo repo;

	@Override
	public ResponseDTO createEmployee(RequestDTO requestDto) {
		
		Employee employee = new Employee();
		employee.setName(requestDto.getName());
		employee.setEmail(requestDto.getEmail());
		employee.setDepartment(requestDto.getDepartment());
		employee.setSalary(requestDto.getSalary());		

		Employee save = repo.save(employee);
		
		ResponseDTO dto = new ResponseDTO();
		
		dto.setId(save.getId());
		dto.setName(save.getName());
		dto.setEmail(save.getEmail());
		dto.setDepartment(save.getDepartment());
		dto.setSalary(save.getSalary());
		
		
		return dto;
		
	}

	@Override
	public ResponseDTO getById(Integer id) {
		
		Employee employee = repo.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
		
		ResponseDTO dto = new ResponseDTO();
		dto.setId(employee.getId());
		dto.setName(employee.getName());
		dto.setEmail(employee.getEmail());
		dto.setDepartment(employee.getDepartment());
		dto.setSalary(employee.getSalary());
		
		return dto ;
	}

	@Override
	public Page<ResponseDTO> getAllEmployee(Pageable pageable) {
		
		Page<Employee> page = repo.findAll(pageable);
		
		Page<ResponseDTO> dtoPage = page.map(employee -> {
			ResponseDTO dto = new ResponseDTO();
			dto.setId(employee.getId());
			dto.setName(employee.getName());
			dto.setEmail(employee.getEmail());
			dto.setDepartment(employee.getDepartment());
			dto.setSalary(employee.getSalary());
			
			return  dto;
		});
		
		return dtoPage;
	}

	@Override
	public ResponseDTO updateEmployee(Integer id, RequestDTO requestDTO) {
		
		Employee employee = repo.findById(id).orElseThrow(() -> new RuntimeException("Id not found"));
		employee.setName(requestDTO.getName());
		employee.setEmail(requestDTO.getEmail());
		employee.setDepartment(requestDTO.getDepartment());
		employee.setSalary(requestDTO.getSalary());
		
		Employee save = repo.save(employee);
		
		ResponseDTO dto = new ResponseDTO();
		dto.setId(save.getId());
		dto.setName(save.getName());
		dto.setEmail(save.getEmail());
		dto.setDepartment(save.getDepartment());
		dto.setSalary(save.getSalary());
			
		return dto;
	}

	@Override
	public void deleteEmployee(Integer id) {
		
		Employee emp = repo.findById(id).orElseThrow(() -> new RuntimeException("Id not found !"));
		
		repo.delete(emp);	
		
	}

}
