package com.global.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.model.Employees;
import com.global.hr.repo.EmployeesRepo;
@RestController
@RequestMapping("/employees")
public class EmployeesController {
	@Autowired
	private EmployeesRepo employeesRepo;
	@GetMapping("/count")
	public int countEmployees() {
		return employeesRepo.count();
	}
	@GetMapping("/{id}")
	public Employees showEmployee(@PathVariable long id) {
		return employeesRepo.findById(id);
	}
	@GetMapping("/show")
	public List<Employees> showEmployees() {
		return employeesRepo.findAll();
	}
}
