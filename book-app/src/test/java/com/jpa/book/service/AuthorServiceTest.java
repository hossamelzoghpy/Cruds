package com.jpa.book.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockitoSession;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.jpa.book.entity.Author;
import com.jpa.book.repo.AuthorRepo;

@SpringBootTest
public class AuthorServiceTest {
	@Autowired
	AuthorService authorService;
	@MockBean
	AuthorRepo authorRepo;
	@Test
	void emailNotFoundTest() {
		Optional<Author> param=Optional.of(new Author(1L,"ali","123.145.5.5","ali@gmail.com"));
		Mockito.when(authorRepo.findByEmail(Mockito.anyString())).thenReturn(param);
		Optional<Author> author=authorService.findByEmail("m@gmail.com");
		assertEquals(true, author.isPresent());
		assertEquals("ali@gmail.com", author.get().getEmail());
	}
}
