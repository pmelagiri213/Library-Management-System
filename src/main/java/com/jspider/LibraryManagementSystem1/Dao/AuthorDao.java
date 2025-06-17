package com.jspider.LibraryManagementSystem1.Dao;

import java.util.List;
import java.util.Optional;

import com.jspider.LibraryManagementSystem1.Entity.Author;

public interface AuthorDao {
	Optional<Author> getAuthorById(int id);
	List<Author> getAllAuthors();
	Author saveOrUpdateAuthor(Author author);
	void deleteAuthorById(int id);
}
