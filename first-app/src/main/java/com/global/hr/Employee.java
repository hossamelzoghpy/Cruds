package com.global.hr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Employee {
	@GetMapping
	 public String hello() {
		 return "Hello hossam";
	 }
}
