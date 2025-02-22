package com.jpa.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.book.base.BaseService;
import com.jpa.book.entity.Author;
import com.jpa.book.entity.Book;
import com.jpa.book.repo.BookRepo;

@Service
public class BookService extends BaseService<Book,Long> {
	@Autowired
	private BookRepo bookRepo;
	@Autowired
	private BaseService<Author,Long> baseService;
	
	public Book insert(Book entity) {
		/*if(entity.getId()!=null) {
			throw  new RuntimeException();
		}*/
		if( entity.getAuthor().getId()!=null) {
			entity.setAuthor(baseService.findById(entity.getAuthor().getId()));
			
		}
		return bookRepo.save(entity);
	}
	public Book update(Book entity) {
		Book book=this.findById(entity.getId());
		book.setName(entity.getName());
		return super.update(entity);
	}
	
	public int deletByAuthor(Long id) {
		return bookRepo.deleteByAuthor(id);
	}
	public Page<Book> filter(String name,int pageNum,int pageSize,Boolean isAsc,String orderBy) {
		if(name.isEmpty()||name.isBlank()||name==null) {
			name=null;
		}
		Pageable page=PageRequest.of(pageNum, pageSize,Sort.by(isAsc?Direction.ASC:Direction.DESC,orderBy));
		return bookRepo.filter(name,page);
	}
}
