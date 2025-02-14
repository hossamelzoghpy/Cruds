package com.global.hr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.global.hr.model.Employees;
import com.global.hr.repo.EmployeesRepo;
@Component
public class EmployeesData implements CommandLineRunner {
	@Autowired
	private EmployeesRepo emp;
	@Override
	public void run(String... args) throws Exception {
		if(emp.count()==0) {
			emp.insert(new Employees(1L,"Hossam",20000.0));
			emp.insert(new Employees(2L,"Ahmed",50000.0));
			emp.insert(new Employees(3L,"Sayed",120000.0));
			emp.insert(new Employees(4L,"Elzoghpy",30000.0));
		}
		
	}

}
