package com.jspider.LibraryManagementSystem1.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.LibraryManagementSystem1.DaoImpl.BookDaoImpl;
import com.jspider.LibraryManagementSystem1.Entity.Book;

@Service
public class BookService {
	
	@Autowired
	private BookDaoImpl bookDaoImpl;
	
	
	//Get all Books
	public List<Book> getAllBooks(){
		return bookDaoImpl.getAllBooks();
	}
	
	
	//Get a Book by an Id
	public Optional<Book> getById(int id) {
		return bookDaoImpl.getBookById(id);
	}
	
	
	//Save and Update Book record
	public Book saveOrUpdateBook(Book book) {
		return bookDaoImpl.saveOrUpdateBook(book);
	}
	
	
	//Delete a Book record by Book Id
	public void deleteById(int id) {
		bookDaoImpl.deleteBookById(id);
	}
}
