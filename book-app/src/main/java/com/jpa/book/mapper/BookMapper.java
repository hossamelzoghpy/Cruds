package com.jpa.book.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.book.dto.BookDto;
import com.jpa.book.entity.Book;



@Mapper(uses = {AuthorMapper.class})
public interface BookMapper {

	
	@Mapping(target = "author" , ignore = true)
	@Mapping(target = "authorName" , source = "author.name")
	@Mapping(target = "authorEmail" , source = "author.email")
	BookDto map(Book entity);

	@Mapping(source = "authorName" , target = "author.name")
	@Mapping(source = "authorEmail" , target = "author.email")
	Book unMap(BookDto dto);
	
	

}
