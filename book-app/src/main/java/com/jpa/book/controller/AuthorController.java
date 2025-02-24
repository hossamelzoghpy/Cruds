package com.jpa.book.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.book.dto.AuthorDto;
import com.jpa.book.entity.Author;
import com.jpa.book.mapper.AuthorMapper;
import com.jpa.book.service.AuthorService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;
    private final AuthorMapper map;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Author author = authorService.findById(id);
        AuthorDto dto = map.mapToDto(author);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/spec")
    public ResponseEntity<?> findBySpecName(@RequestParam String authorName) {
        List<Author> authors = authorService.findBySpecName(authorName);
        List<AuthorDto> dto = new ArrayList<>();

        // Map each Author to AuthorDto
        authors.forEach(author -> {
            AuthorDto ele = new AuthorDto();
            ele.setId(author.getId());
            ele.setFullName(author.getName());
            ele.setEmail(author.getEmail());
            ele.setIpAddress(author.getIpAddress());
            dto.add(ele);
        });

        return ResponseEntity.ok(dto);
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<Author> authors = authorService.findAll();
        List<AuthorDto> dto = map.mapListToDto(authors); // Map all authors to DTOs
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/insert")
    public ResponseEntity<?> insertAuthor(@Valid @RequestBody AuthorDto dto) {
        Author entity = map.mapToEntity(dto);
        Author author = authorService.insert(entity);
        AuthorDto ele = map.mapToDto(author);
        return ResponseEntity.ok(ele);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAuthor(@Valid @RequestBody AuthorDto dto) {
        Author entity = map.mapToEntity(dto);
        Author author = authorService.update(entity);
        AuthorDto ele = map.mapToDto(author);
        return ResponseEntity.ok(ele);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Long id) {
        authorService.delete(id);
        return ResponseEntity.ok().build();  // Returning an empty response after successful deletion
    }
}
