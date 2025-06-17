package com.jspider.LibraryManagementSystem1.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.LibraryManagementSystem1.DaoImpl.AuthorDaoImpl;
import com.jspider.LibraryManagementSystem1.Entity.Author;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorDaoImpl authorDaoImpl;
	
	//Get All Authors
	public List<Author> getAllAuthors(){
		return authorDaoImpl.getAllAuthors();
	}
	
	//Get and author record by author Id
	public Optional<Author> getAuthorById(int id) {
		return authorDaoImpl.getAuthorById(id);
	}
	
	//Save and Update the author record
	public Author saveOrUpdateAuthor(Author author) {
		return authorDaoImpl.saveOrUpdateAuthor(author);
	}
	
	//Delete an author record by author Id
	public void deleteAuthorById(int id) {
		authorDaoImpl.deleteAuthorById(id);
	}
}
