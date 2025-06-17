package com.jspider.LibraryManagementSystem1.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.LibraryManagementSystem1.Entity.Book;
import com.jspider.LibraryManagementSystem1.Service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	//Get all the Book records
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooksRecord(){
		List<Book> books = bookService.getAllBooks();
		
		return ResponseEntity.ok(books);
	}
	
	
	//Get particular Book record by Book Id
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable int id){
		Optional<Book> book = bookService.getById(id);
		
		if(book.isPresent()) {
			return ResponseEntity.ok(book.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	//Save the Book record
	@PostMapping
	public ResponseEntity<Book> saveBookRecord(@RequestBody Book book){
		Book createdBook = bookService.saveOrUpdateBook(book);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
	}
	
	
	//Update the existing Book record
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBookRecord(@RequestBody Book book, @PathVariable int id){
		Optional<Book> existingBook = bookService.getById(id);
		
		if(existingBook.isPresent()) {
			book.setBookId(id);
			bookService.saveOrUpdateBook(book);
			return ResponseEntity.ok(book);
			
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	//Delete the book record by Id
	@DeleteMapping("/{id}")
	public ResponseEntity<Book> deleteBookRecordById(@PathVariable int id){
		
		if(bookService.getById(id).isPresent()) {
			
			bookService.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
