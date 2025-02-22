package com.jpa.hr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;

@Entity
@NamedQuery(name="Employee.findBySalary",query="select emp from Employee emp where emp.salary>=:salary")
public class Employee {
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(Long id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id")
	private Long id;
	@Column(name="emp_name")
	private String name;
	private double salary;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="department_id")
	//@JsonIgnore
	private Department department;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
