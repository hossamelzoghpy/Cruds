package com.jpa.book.service;


import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jpa.book.dto.PostsDto;

@Service
public class PostService {
	
	private static String url="https://jsonplaceholder.typicode.com/posts";
	private RestTemplate restTemplate=new RestTemplate();
	
	public PostsDto getPostById(Long id) {
		ResponseEntity<PostsDto> response=restTemplate.getForEntity(url+"/"+id, PostsDto.class);
		return response.getBody();
	}
	public List<PostsDto> getAllPosts() {
		ResponseEntity<List> response=restTemplate.getForEntity(url, List.class);
		return response.getBody();
	}
	public PostsDto addPost(PostsDto post) {
		HttpHeaders headers=new HttpHeaders();
		headers.add("accept", "application.json");
		headers.add("language", "en");
		HttpEntity<PostsDto> request=new HttpEntity(post,headers);
		ResponseEntity<PostsDto> response=restTemplate.postForEntity(url, request, PostsDto.class);
		return response.getBody();
	}
	public void updatePost(PostsDto post) {
		HttpEntity<PostsDto> request=new HttpEntity(post);
		restTemplate.put(url, request);
		
	}
	public void deletePostById(Long id) {
		restTemplate.delete(url+"/"+id);
		
	}
}
