package com.global.hr.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.global.hr.model.Employees;

public class EmployeesMapper implements RowMapper<Employees> {

	@Override
	public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Employees(rs.getLong("id"),rs.getString("name"),rs.getDouble("salary"));
	}

}
