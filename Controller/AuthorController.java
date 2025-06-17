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

import com.jspider.LibraryManagementSystem1.Entity.Author;
import com.jspider.LibraryManagementSystem1.Service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	
	//Get all the Author Records
	@GetMapping
	public ResponseEntity<List<Author>> getAllAuthorsRecord(){
		List<Author> author = authorService.getAllAuthors();
		
		return ResponseEntity.ok(author);
	}
	
	
	//Get a particular Author record by Author Id
	@GetMapping("/{id}")
	public ResponseEntity<Author> getAuthorById(@PathVariable int id){
		Optional<Author> author = authorService.getAuthorById(id);
		
		if(author.isPresent()) {
			return ResponseEntity.ok(author.get());
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	
	//Save the Author record
	@PostMapping
	public ResponseEntity<Author> saveAuthorRecord(@RequestBody Author author){
		Author createdAuthor = authorService.saveOrUpdateAuthor(author);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdAuthor);
	}
	
	
	//Update the Author record
	@PutMapping("/{id}")
	public ResponseEntity<Author> updateAuthorRecord(@RequestBody Author author, @PathVariable int id){
		Optional<Author> existingAuthor = authorService.getAuthorById(id);
		
		if(existingAuthor.isPresent()) {
			author.setAuthorId(id);
			authorService.saveOrUpdateAuthor(author);
			return ResponseEntity.ok(author);
		}
		
		return ResponseEntity.notFound().build();
	
	}
	
	
	//Delete the Author record by Id
	@DeleteMapping("/{id}")
	public ResponseEntity<Author> deleteAuthorRecord(@PathVariable int id){
		Optional<Author> author = authorService.getAuthorById(id);
		
		if(author.isPresent()) {
			authorService.deleteAuthorById(id);
			return ResponseEntity.noContent().build();
		}
		
		else {
			return ResponseEntity.notFound().build();
		}
	}
}