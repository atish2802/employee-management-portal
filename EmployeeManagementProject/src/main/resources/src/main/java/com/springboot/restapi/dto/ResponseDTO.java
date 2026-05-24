package com.springboot.restapi.dto;

public class ResponseDTO {
	
	private Integer id;
    private String name;
    private String email;
    private String department;
    private Double salary;
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
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public ResponseDTO(Integer id, String name, String email, String department, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
		this.salary = salary;
	}
	public ResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ResponseDTO [id=" + id + ", name=" + name + ", email=" + email + ", department=" + department
				+ ", salary=" + salary + "]";
	}
    
    
}
