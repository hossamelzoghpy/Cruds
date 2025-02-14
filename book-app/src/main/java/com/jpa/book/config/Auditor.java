package com.jpa.book.config;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class Auditor implements AuditorAware {

	@Override
	public Optional getCurrentAuditor() {
		// TODO Auto-generated method stub
		//You should get username from spring security
		return Optional.of("Hossam");
	}

}
