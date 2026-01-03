package com.springboot.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.restapi.dto.RequestDTO;
import com.springboot.restapi.dto.ResponseDTO;
import com.springboot.restapi.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ui/employees")
public class EmployeeUIController {
	
	@Autowired
	private EmployeeService service;
	
		@GetMapping
	    public String listEmployees(Model model) {
			Page<ResponseDTO> employees = service.getAllEmployee(Pageable.unpaged());
	        model.addAttribute("employees", employees);
	        return "employees";
	    }

	    @GetMapping("/add")
	    public String showAddForm(Model model) {
	        model.addAttribute("employee", new RequestDTO());
	        return "add-employee";
	    }

	    @PostMapping("/add")
	    public String addEmployee(@Valid @ModelAttribute("employee") RequestDTO dto) {
	        service.createEmployee(dto);
	        return "redirect:/ui/employees";
	    }

	    @GetMapping("/edit/{id}")
	    public String showEditForm(@PathVariable Integer id, Model model) {
	    	ResponseDTO emp = service.getById(id);
	    	
	        RequestDTO dto = new RequestDTO();
	        dto.setName(emp.getName());
	        dto.setEmail(emp.getEmail());
	        dto.setDepartment(emp.getDepartment());
	        dto.setSalary(emp.getSalary());
	        model.addAttribute("employee", dto);
	        model.addAttribute("id", emp.getId());
	        return "edit-employee";
	    }

	    @PostMapping("/edit")
	    public String editEmployee(@RequestParam Integer id,
	                               @Valid @ModelAttribute("employee") RequestDTO dto) {
	        service.updateEmployee(dto.getId(), dto);
	        return "redirect:/ui/employees";
	    }

	    @GetMapping("/delete/{id}")
	    public String deleteEmployee(@PathVariable Integer id) {
	        service.deleteEmployee(id);
	        return "redirect:/ui/employees";
	    }
}
