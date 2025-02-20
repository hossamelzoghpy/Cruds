package com.jpa.hr.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jpa.hr.entity.Role;
import com.jpa.hr.entity.User;
import com.jpa.hr.service.RoleService;
import com.jpa.hr.service.UserService;

@Component
public class AppStartUp implements CommandLineRunner {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@Override
	public void run(String... args) throws Exception {
		if(userService.getAllusers().isEmpty()) {
		//Create Role
		Role role1=new Role();
		role1.setName("Admin");
		roleService.insertRole(role1);
		/////////////////////////////
		Role role2=new Role();
		role2.setName("User");
		roleService.insertRole(role2);
		
		Set<Role> adminRole=new HashSet<>();
		adminRole.add(role1);
		Set<Role> userRole=new HashSet<>();
		userRole.add(role2);
		//Create User
		User user1=new User();
		user1.setUserName("admin");
		user1.setPassword("admin");
		user1.setRoles(adminRole);
		userService.insertUser(user1);
		///////////////////////////////
		User user2=new User();
		user2.setUserName("user");
		user2.setPassword("user");
		user2.setRoles(userRole);
		userService.insertUser(user2);
		}
	}

}
