package com.jpa.hr.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.jpa.hr.entity.Department;
import com.jpa.hr.entity.Employee;
@Repository
public interface DepartmentRepo extends CrudRepository<Department,Long> {
	//List<Employee> findDepartment(long id);
	
}
