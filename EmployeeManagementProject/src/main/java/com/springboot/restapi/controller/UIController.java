package com.springboot.restapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}

	@GetMapping("/add-employee")
	public String addEmployee() {
		return "add-employee";
	}

	@GetMapping("/edit-employee")
	public String editEmployee() {
		return "edit-employee";
	}

	@GetMapping("/request-update")
	public String requestUpdate() {
		return "request-update";
	}

}