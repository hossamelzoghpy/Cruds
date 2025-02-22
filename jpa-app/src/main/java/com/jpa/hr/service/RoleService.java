package com.jpa.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.hr.entity.Role;
import com.jpa.hr.repo.RoleRepo;


@Service
public class RoleService {
	@Autowired
	private RoleRepo roleRepo;
	public long getCount() {
		return roleRepo.count();
	}
	public Role getRole(Long id){
		return roleRepo.findById(id).orElseThrow();
	}
	public List<Role> getAllRoles(){
		return (List<Role>) roleRepo.findAll();
	}
	public Role insertRole(Role role) {
		return roleRepo.save(role);
	}
	public Role findByName(String roleName) {
		return roleRepo.findByName(roleName);
	}
	
	public Role update(Role role) {
		Role current=roleRepo.findById(role.getId()).orElseThrow();
		current.setName(role.getName());
		return roleRepo.save(current);
	}
	
}
