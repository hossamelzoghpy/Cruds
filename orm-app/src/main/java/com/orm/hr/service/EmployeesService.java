package com.orm.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.orm.hr.entity.Employees;
import com.orm.hr.impl.EmployeesImpl;
@Service
public class EmployeesService {
	@Autowired
	private EmployeesImpl emp;
	public long count() {
		return emp.count();
	}
	public Employees getemployee(long id){
		return emp.findById(id).get();
	}
	public ResponseEntity<?> getemployees(){
		return ResponseEntity.ok(emp.findAll());
	}
	public List<Employees> getemployeeByNameOrSalary( String name,double salary){
		return (List<Employees>) emp.findByNameOrSalary(name, salary);
	}
	public Employees insertemployee(Employees employee){
		return emp.save(employee);
	}
	public List<Employees>insertemployees(List<Employees> employee){
		return  (List<Employees>) emp.saveAll(employee);
	}
	public Employees updateemployee(Employees employee){
		return emp.save(employee);
	}
	public int updateSalary(double salary,long id){
		return emp.updateSalary(salary, id);
	}
	public void DeleteemployeeById(long id){
		emp.deleteById(id);
	}
	public void DeleteemployeeByIdInBody(Employees employee ){
		emp.delete(employee);
	}
	public void Deleteemployees( ){
		emp.deleteAll();
	}
}
