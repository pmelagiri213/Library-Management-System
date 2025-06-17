package com.jspider.LibraryManagementSystem1.Dao;

import java.util.List;
import java.util.Optional;

import com.jspider.LibraryManagementSystem1.Entity.Book;

public interface BookDao  {
	Optional<Book> getBookById(int id);
	List<Book> getAllBooks();
	Book saveOrUpdateBook(Book book);
	void deleteBookById(int id);
}
