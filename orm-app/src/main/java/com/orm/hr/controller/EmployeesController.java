package com.orm.hr.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.orm.hr.entity.Employees;

import com.orm.hr.service.EmployeesService;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
	Logger log=LoggerFactory.getLogger(EmployeesController.class);
	private EmployeesService emp;
	//@Autowired
	public EmployeesController(EmployeesService emp) {
		super();
		this.emp = emp;
	}
	@GetMapping("/count")
	public long count() {
		return emp.count();
	}
	
	@GetMapping("/{id}")
	public Employees getemployee(@PathVariable long id,@RequestHeader("language") String lang){
		log.info("language is "+lang);
		return emp.getemployee(id);
	}
	@GetMapping("")
	public ResponseEntity<?> getemployees(){
		return emp.getemployees();
	}
	@GetMapping("/filter")
	public List<Employees> getemployeeByNameOrSalary(@RequestParam String name,@RequestParam double salary){
		return (List<Employees>) emp.getemployeeByNameOrSalary(name, salary);
	}
	@PostMapping("")
	public Employees insertemployee(@RequestBody Employees employee){
		return emp.insertemployee(employee);
	}
	@PostMapping("/insert")
	public List<Employees>insertemployees(@RequestBody List<Employees> employee){
		return  (List<Employees>) emp.insertemployees(employee);
	}
	@PutMapping("")
	public Employees updateemployee(@RequestBody Employees employee){
		return emp.updateemployee(employee);
	}
	@PutMapping("/salary")
	public int updatesalary(@RequestParam double salary,@RequestParam long id){
		return emp.updateSalary(salary, id);
	}
	@DeleteMapping("/{id}")
	public void DeleteemployeeById(@PathVariable long id){
		emp.DeleteemployeeById(id);
	}
	@DeleteMapping("/delete/id")
	public void DeleteemployeeByIdInBody(@RequestBody Employees employee ){
		emp.DeleteemployeeByIdInBody(employee);
	}
	@DeleteMapping("/delete")
	public void Deleteemployees( ){
		emp.Deleteemployees();
	}
}
