package com.jpa.hr.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpa.hr.entity.Employee;
import com.jpa.hr.entity.Role;
import com.jpa.hr.entity.User;
@Repository
public interface RoleRepo extends CrudRepository<Role,Long> {
	Role findByName(String roleName);
}
