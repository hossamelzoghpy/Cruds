package com.orm.hr.impl;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orm.hr.entity.Employees;
@Repository
public interface EmployeesImpl extends CrudRepository<Employees,Long>{
	List<Employees> findByNameOrSalary(String name,double salary);
	@Modifying
	@Query("update employees set salary=:salary where id=:id")
	int updateSalary(double salary,long id);

}
