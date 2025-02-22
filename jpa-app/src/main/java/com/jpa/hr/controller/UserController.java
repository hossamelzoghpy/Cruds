package com.jpa.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.jpa.hr.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@PutMapping("/update/{roleName}")
	public ResponseEntity<?> update(@PathVariable String roleName) {
		userService.insertRoles(roleName);
		return ResponseEntity.ok(null);
	}
}
