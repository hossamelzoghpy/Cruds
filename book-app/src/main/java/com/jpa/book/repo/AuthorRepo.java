package com.jpa.book.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jpa.book.base.BaseRepo;
import com.jpa.book.entity.Author;
@Repository
public interface AuthorRepo extends  BaseRepo<Author,Long>{
}
