package com.jpa.book;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.book.entity.Author;
import com.jpa.book.service.AuthorService;

import lombok.RequiredArgsConstructor;

@SpringBootTest
class BookAppApplicationTests {
//	@Autowired
//	AuthorService authorService;
//	
////	public BookAppApplicationTests(AuthorService authorService) {
////		super();
////		this.authorService = authorService;
////	}
//
//	//test on find by email integration test
//	@Test
//	void emailNotFoundTest() {
//		Optional<Author> author=authorService.findByEmail("hoss@gmail.com");
//		assertEquals(false, author.isPresent());
//	}
//	@Test
//	void emailFoundTest() {
//		Optional<Author> author=authorService.findByEmail("noo@gmail");
//		assertEquals(true, author.isPresent());
//		assertEquals("noo@gmail", author.get().getEmail());
//	}

}
