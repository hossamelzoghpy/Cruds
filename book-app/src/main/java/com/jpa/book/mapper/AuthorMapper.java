package com.jpa.book.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.jpa.book.dto.AuthorDto;
import com.jpa.book.entity.Author;

@Mapper()  
public interface AuthorMapper {
	
	//map from entity to dto
	@Mappings({
		@Mapping(source="name",target="fullName"),
		//@Mapping(target="ipAddress",ignore = true)
	})
	AuthorDto mapToDto(Author entity);
	
	@Mapping(source="name",target="fullName")
	List<AuthorDto> mapListToDto(List<Author> entity);
	
	//map from dto to entity
	@Mapping(source="fullName",target="name")
	Author mapToEntity(AuthorDto dto);
}
