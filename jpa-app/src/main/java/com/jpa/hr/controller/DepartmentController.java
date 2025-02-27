package com.jpa.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.hr.entity.Department;
import com.jpa.hr.entity.Employee;
import com.jpa.hr.service.DepartmentService;
import com.jpa.hr.service.EmployeeService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/{id}")
	public Department getDepartmentById(@PathVariable Long id) {
		return departmentService.getDepartment(id);
	}
	@GetMapping("")
	public List< Department> getAll() {
		return departmentService.getAll();
	}
	@PostMapping("/insert")
	public Department insertDepartment(@RequestBody Department dept) {
		return departmentService.insertDepartment(dept);
	}
	@PutMapping("/update")
	public Department update(@RequestBody Department dept) {
		return departmentService.update(dept);
	}
}
