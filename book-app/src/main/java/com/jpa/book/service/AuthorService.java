package com.jpa.book.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.book.base.BaseService;
import com.jpa.book.entity.Author;
import com.jpa.book.error.DuplicateRecordException;
import com.jpa.book.repo.AuthorRepo;
import com.jpa.book.repo.AuthorSpec;

@Service
public class AuthorService extends BaseService<Author,Long>  {
	@Autowired
	private AuthorRepo authorRepo;
	
	Logger log=LoggerFactory.getLogger(AuthorService.class);
	@Override
	public Author insert(Author entity) {
		if(!entity.getEmail().isEmpty()&&entity.getEmail()!=null) {
			Optional<Author> author=findByEmail(entity.getEmail());
			log.info("author name is {} and email is {} " , entity.getName(), entity.getEmail());
			if(author.isPresent()) {
				log.error("This email already found with anther author");
				throw new DuplicateRecordException("This email is Exist");
			}
		}
			
		
		return super.insert(entity);
		
		
	}
	public Author update(Author entity) {
		Author author=this.findById(entity.getId());
		author.setName(entity.getName());
		return super.update(author);
	}
	public List<Author> findBySpecName(String authorName){
		AuthorSpec spec=new AuthorSpec(authorName);
		return authorRepo.findAll(spec);
	}
	public Optional<Author> findByEmail(String email){
		return authorRepo.findByEmail(email);
	}
}
