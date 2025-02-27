package com.jpa.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jpa.hr.entity.Department;
import com.jpa.hr.entity.Employee;
import com.jpa.hr.projection.EmployeeProjection;
import com.jpa.hr.projection.HrStatic;
import com.jpa.hr.repo.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private DepartmentService departmentService;
	public long getCount() {
		return employeeRepo.count();
	}
	public Employee getemployee(Long id){
		return employeeRepo.findById(id).orElseThrow();
	}
	public List<Employee> getEmployeeBySalary(Double salary){
		return employeeRepo.findBySalary(salary);
	}
	public List<Employee> getAllEmployees(){
		return (List<Employee>) employeeRepo.findAll();
	}
	public List<EmployeeProjection> allProjection(){
		return employeeRepo.allProjection();
	}
	public HrStatic getStatic() {
		return employeeRepo.hrstatic();
	}
	public Employee insertEmployee(Employee employee) {
		if(employee.getDepartment() != null&& employee.getDepartment().getId()!=null) {
			employee.setDepartment(departmentService.getDepartment(employee.getDepartment().getId()));
			
		}
		
		return employeeRepo.save(employee);
	}
	public Page<EmployeeProjection> getByName(String name,int pageNum,int pageSize,Boolean isAsc,String orderBy) {
		if(name.isEmpty()||name.isBlank()||name==null) {
			name=null;
		}
		Pageable page=PageRequest.of(0, 5,Sort.by(isAsc?Direction.ASC:Direction.DESC,orderBy));
		return employeeRepo.filter(name,page);
	}
	public Employee update(Employee emp) {
		Employee current=employeeRepo.findById(emp.getId()).orElseThrow();
		current.setName(emp.getName());
		current.setDepartment(emp.getDepartment());
		current.setSalary(emp.getSalary());
		return employeeRepo.save(current);
	}
	public List<Employee> getAllEmployeesByDepartment(Long id){
		return employeeRepo.findByDepartmentId(id);
	}
}
