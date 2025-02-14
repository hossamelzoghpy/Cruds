package com.jpa.book.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.book.entity.Author;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseService<T extends BaseEntity<ID>,ID extends Number> {
	@Autowired
	private BaseRepo<T,ID> baseRepo;
	public T findById(ID id) {
		return baseRepo.findById(id).orElseThrow();
	}
	public T getById(ID id) {
		return baseRepo.getById(id);
	}
	public List<T> findAll(){
		return (List<T>)baseRepo.findAll();
	}
	public T insert(T entity) {
		/*if(entity.getId()!=null) {
			throw  new RuntimeException();
		}*/
		return baseRepo.save(entity);
	}
	public T update(T entity) {
		
		return baseRepo.save(entity);
	}
	public void delete(ID id) {
		baseRepo.deleteById(id);
	}
}
