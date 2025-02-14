package com.jpa.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.hr.entity.Department;
import com.jpa.hr.entity.Employee;
import com.jpa.hr.repo.DepartmentRepo;


@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepo departmentRepo;

	public Department getDepartment(Long id){
		return departmentRepo.findById(id).orElseThrow();
	}
	public Department insertDepartment(Department dept) {
		return departmentRepo.save(dept);
	}
	public Department update(Department dept) {
		Department current=departmentRepo.findById(dept.getId()).orElseThrow();
		current.setName(dept.getName());
		return departmentRepo.save(current);
	}
	public List<Department> getAll() {
		return (List<Department>) departmentRepo.findAll();
	}
}
