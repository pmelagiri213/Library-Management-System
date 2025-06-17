package com.jspider.LibraryManagementSystem1.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	
	private String title;
	
	@OneToOne
	@JoinColumn(name = "Author Id")
	private Author author;
	
	@ManyToMany
	@JoinTable(name = "Books_and_Publishers", joinColumns = {@JoinColumn(name = "Book_Id")}, inverseJoinColumns = {@JoinColumn(name = "Publisher_Id")})
	private List<Publisher> publishers;
	
	

	public Book(int bookId, String title, Author author, List<Publisher> publishers) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.publishers = publishers;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Publisher> getPublishers() {
		return publishers;
	}

	public void setPublishers(List<Publisher> publishers) {
		this.publishers = publishers;
	}

}