package com.jpa.book.dto;


import com.jpa.book.base.BaseDto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto extends BaseDto<Long> {
		
	@NotBlank
	private String name ;
	
	@Min(value = 200)
	private double price;
	
	@NotNull
	private AuthorDto author;
	
	private String authorName;
	
	private String authorEmail;
	
	//private Boolean isFavorate;

	
}