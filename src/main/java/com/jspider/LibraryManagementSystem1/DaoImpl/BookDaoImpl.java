package com.jspider.LibraryManagementSystem1.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.LibraryManagementSystem1.Dao.BookDao;
import com.jspider.LibraryManagementSystem1.Entity.Book;
import com.jspider.LibraryManagementSystem1.Repository.BookRepository;

@Repository
public class BookDaoImpl implements BookDao {
	
	@Autowired
	private BookRepository bookRepo;
	
	@Override
	public Optional<Book> getBookById(int id){
		return bookRepo.findById(id);
	}
	
	@Override
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	@Override
	public Book saveOrUpdateBook(Book book) {
		return bookRepo.save(book);
	}
	
	@Override
	public void deleteBookById(int id) {
		Optional<Book> existingBook = bookRepo.findById(id);
		
		if(existingBook.isPresent()) {
			bookRepo.deleteById(id);
		}
		
		else {
			System.out.println("The entered id number "+id+" is incorrect!");
		}
	}
}
