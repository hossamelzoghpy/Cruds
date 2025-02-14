package com.jpa.book.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//Java based config
@Configuration
@EnableJpaAuditing(auditorAwareRef="auditorAware")
public class WebConfig {
	@Bean
	public AuditorAware<String> auditorAware(){
		return new Auditor();
	}

}
