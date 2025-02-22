package com.jpa.book.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.book.base.BaseRepo;
import com.jpa.book.entity.Author;
import com.jpa.book.entity.Book;
@Repository
public interface BookRepo extends  BaseRepo<Book,Long> {

	@Override
	@EntityGraph(attributePaths= {"author"})//For lazy fetch to ignore multi Queries
	Optional<Book> findById(Long id) ;

	@Override
	@EntityGraph(attributePaths= {"author"})
	List<Book> findAll();
	@Transactional
	@Modifying
	@Query(value="delete from Book where author.id=:id")
	int deleteByAuthor(Long id);
	@Query(value="select book from #{#entityName} book where(:name is null or book.name like :name ) ")
	Page<Book> filter(String name,Pageable pageable);
}
