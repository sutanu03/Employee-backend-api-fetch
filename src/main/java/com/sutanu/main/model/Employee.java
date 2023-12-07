package com.sutanu.main.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;

@Component
@Entity
@Table(name = "Employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long EmployeeID;
	private String FirstName;
	private String City;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Long employeeID, String firstName, String city) {
		super();
		EmployeeID = employeeID;
		FirstName = firstName;
		City = city;
	}
	public Long getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(Long employeeID) {
		EmployeeID = employeeID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	@Override
	public String toString() {
		return "Employee [EmployeeID=" + EmployeeID + ", FirstName=" + FirstName + ", City=" + City + "]";
	}
	
}
