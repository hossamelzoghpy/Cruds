package com.jpa.book.dto;

import com.jpa.book.base.BaseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto extends BaseDto<Long> {
	private String fullName;
	private String ipAddress;
	private String email;
}
