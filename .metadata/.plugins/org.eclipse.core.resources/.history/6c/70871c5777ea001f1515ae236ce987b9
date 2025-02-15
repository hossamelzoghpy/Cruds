package com.jpa.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.book.base.BaseService;
import com.jpa.book.entity.Author;
import com.jpa.book.repo.AuthorRepo;

@Service
public class AuthorService extends BaseService<Author,Long>  {
	public Author update(Author entity) {
		Author author=this.findById(entity.getId());
		author.setName(entity.getName());
		return super.update(author);
	}
}
