package com.jpa.book.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.book.entity.Author;


@SpringBootTest
public class AuthorRepoTest {
	@Autowired
	AuthorRepo authorRepo;
	@Test
	void emailNotFoundTest() {
		Optional<Author> author=authorRepo.findByEmail("hoss@gmail.com");
		assertEquals(false, author.isPresent());
	}
}
