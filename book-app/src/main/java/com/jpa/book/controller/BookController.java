package com.jpa.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.book.entity.Book;
import com.jpa.book.repo.BookRepo;
import com.jpa.book.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookService;
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		return ResponseEntity.ok(bookService.findById(id));
	}
	@GetMapping("")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(bookService.findAll());
	}
	@GetMapping("/name")
	public  ResponseEntity<?> filter(@RequestParam String name,@RequestParam 
			int pageNum,@RequestParam  int pageSize,@RequestParam Boolean isAsc,@RequestParam String orderBy) {
		
		return ResponseEntity.ok(bookService.filter(name, pageNum, pageSize, isAsc, orderBy));
	}
	@PostMapping("/insert")
	public ResponseEntity<?> insertBook(@Valid @RequestBody Book book) {
		return ResponseEntity.ok(bookService.insert(book));
	}
	@PutMapping("/update")
	public ResponseEntity<?> updateBook(@Valid @RequestBody Book book) {
		return ResponseEntity.ok(bookService.update(book));
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> updateBook(@PathVariable Long id) {
		bookService.delete(id);
	
		return ResponseEntity.ok(null);
	}
	@DeleteMapping("/author/delete/{id}")
	public ResponseEntity<?> deleteByAuthor(@PathVariable Long id) {
		return ResponseEntity.ok(bookService.deletByAuthor(id));
	}
	}
	