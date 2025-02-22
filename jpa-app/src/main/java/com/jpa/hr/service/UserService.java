package com.jpa.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hr.entity.Role;
import com.jpa.hr.entity.User;
import com.jpa.hr.repo.UserRepo;



@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleService roleService;
	public long getCount() {
		return userRepo.count();
	}
	public User getUser(Long id){
		return userRepo.findById(id).orElseThrow();
	}
	public List<User> getAllusers(){
		return (List<User>) userRepo.findAll();
	}
	public User insertUser(User user) {
		return userRepo.save(user);
	}
	
	public User update(User user) {
		User current=userRepo.findById(user.getId()).orElseThrow();
		current.setUserName(user.getUserName());
		current.setPassword(user.getPassword());
		current.setRoles(user.getRoles());
		return userRepo.save(current);
	}
	@Modifying
	@Transactional
	public void insertRoles(String roleName) {
		Role role=roleService.findByName(roleName);
		getAllusers().forEach(user->{
			user.addRole(role);
			userRepo.save(user);
		});
	}
	
}
