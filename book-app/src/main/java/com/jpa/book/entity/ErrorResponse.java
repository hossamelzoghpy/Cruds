package com.jpa.book.entity;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	private Boolean status;
	private String message;
	private LocalDateTime time;
	private List<String> details;
	
	public ErrorResponse(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
		this.status=Boolean.FALSE;
		this.time=LocalDateTime.now();
	}
	
	
}
