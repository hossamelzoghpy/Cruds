package com.jpa.hr.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {
	Long getEmpId();
	String getEmpName();
	Double getSalary();
	@Value("#{target.empId+'  '+target.empName}")
	String getFullOperation();

}
