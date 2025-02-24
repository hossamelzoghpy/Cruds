package com.jpa.book.entity;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jpa.book.base.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="author")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Author extends BaseEntity<Long>{
	@NotNull
	private String name;
	@Pattern(regexp = "^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$",message="{validation.constraints.ip-address.message}")
	private String ipAddress;
	@Email(message="{validation.constraints.email.message}")
	private String email;
	@Formula("(select count(*) from book books where books.author_id = id)")
	private Long countBook;
	@JsonManagedReference    ///to avoid infintiy loop when show author
	@OneToMany(mappedBy="author")
	private Set<Book> books=new HashSet<>();
	private String imagePath;
	//Function Helper
	public void addBook(Book book) {
		books.add(book);
	}
	public void removeBook(Book book) {
		books.remove(book);
	}
	public Author(Long id,@NotNull String name,
			@Pattern(regexp = "^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$", message = "{validation.constraints.ip-address.message}") String ipAddress,
			@Email(message = "{validation.constraints.email.message}") String email) {
		super();
		this.name = name;
		this.ipAddress = ipAddress;
		this.email = email;
	}
	

	

}
