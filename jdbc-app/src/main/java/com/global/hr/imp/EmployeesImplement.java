package com.global.hr.imp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.global.hr.model.Employees;
import com.global.hr.repo.EmployeesRepo;
import com.global.hr.mapper.EmployeesMapper;
@Component
public class EmployeesImplement implements EmployeesRepo{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select count(*) from employees", Integer.class);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Employees findById(long id) {
		
		return jdbcTemplate.queryForObject("select id,name,salary from employees where id=?",
				new Object[]{id},new EmployeesMapper());
	}

	@Override
	public List<Employees> findAll() {
		return jdbcTemplate.query("select id,name,salary from employees",new EmployeesMapper());
	}

	@Override
	public int insert(Employees emp) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("insert into employees (id,name,salary) values(?,?,?)",
				new Object[]{emp.getId(),emp.getName(),emp.getSalary()});
	}

	@Override
	public int update(Employees emp) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("update employees set name=?,salary=?",
				new Object[]{emp.getName(),emp.getSalary()});
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("delete from employees where id=?",new Object[] {id});
	}

}
