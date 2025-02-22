package com.jpa.book.entity;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jpa.book.base.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="book")
public class Book extends BaseEntity<Long> {
	@NotNull(message="Should enter name")
	private String name;
	private Double price;
	
	@Formula("(select count(*) from book)")
	private Long countBook;
	@Transient  //not adding to db
	private Double discount;
	/*the fetch type must be eager but suppose that i need the fetch be lazy so i need to using entity graph or load graph 
	or using DTO(like propagation) to determine what i need to show from entity to losscoupled queries for methods that using join to connect to other entity why?
	to reduce the number of queries and avoid the problem of n+1 of jpa*/
	
	@JsonBackReference  //To Avoid seralization by jackson
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="author_id")
	private Author author;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	@PostLoad //to calculate once the project is up
	public void discount() {
		this.setDiscount(this.price*0.25);
	}
	public Long getCountBook() {
		return countBook;
	}
	public void setCountBook(Long countBook) {
		this.countBook = countBook;
	}

}
