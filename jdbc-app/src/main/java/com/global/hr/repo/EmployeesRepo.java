package com.global.hr.repo;

import java.util.List;

import com.global.hr.model.Employees;

public interface EmployeesRepo {
	int count();
	Employees findById(long id);
	List<Employees> findAll();
	int insert(Employees emp);
	int update(Employees emp);
	int delete(long id);
	
	
}
