package com.springboot.restapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class RequestDTO {
	
	private Integer id;
	
	

	@NotBlank(message = "This field is mendatory ")
	private String name;
	
	@Email(message = "Email format is wrong")
	@NotBlank(message = "This field is mendatory ")
	private String email;
	
	@NotBlank(message = "This field is mendatory ")
	private String department;
	
	private double salary;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public RequestDTO(
			Integer id,@NotBlank(message = "This field is mendatory ") String name,
			@Email(message = "Email format is wrong") @NotBlank(message = "This field is mendatory ") String email,
			@NotBlank(message = "This field is mendatory ") String department,
			@NotBlank(message = "This field is mendatory ") double salary) {
		super();
		this.id=id;
		this.name = name;
		this.email = email;
		this.department = department;
		this.salary = salary;
	}

	public RequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "RequestDTO [id=" + id + "name=" + name + ", email=" + email + ", department=" + department + ", salary=" + salary
				+ "]";
	}
	
	
	
}
