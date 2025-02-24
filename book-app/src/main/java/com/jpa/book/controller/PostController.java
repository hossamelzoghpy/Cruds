package com.jpa.book.controller;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.book.dto.PostsDto;
import com.jpa.book.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
	private PostService postService;

	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getPostById(@PathVariable Long id) {
		
		return ResponseEntity.ok(postService.getPostById(id));
	}
	@GetMapping("")
	public ResponseEntity<?> getAllPost() {
		
		return ResponseEntity.ok(postService.getAllPosts());
	}
	@PostMapping("/add")
	public ResponseEntity<?> addPost(@RequestBody PostsDto post) {
		
		return ResponseEntity.ok(postService.addPost(post));
	}
	@PutMapping("/update")
	public ResponseEntity<?> updatePost(@RequestBody PostsDto post) {
		postService.updatePost(post);
		return ResponseEntity.ok(null);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletePost(@PathVariable Long id) {
		postService.deletePostById(id);
		return ResponseEntity.ok(null);
	}
	

}
