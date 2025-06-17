package com.jspider.LibraryManagementSystem1.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.LibraryManagementSystem1.Dao.AuthorDao;
import com.jspider.LibraryManagementSystem1.Entity.Author;
import com.jspider.LibraryManagementSystem1.Repository.AuthorRepository;

@Repository
public class AuthorDaoImpl implements AuthorDao {
	
	@Autowired
	private AuthorRepository authorRepo;
	
	@Override
	public Optional<Author> getAuthorById(int id){
		return authorRepo.findById(id);
	}
	
	@Override
	public List<Author> getAllAuthors(){
		return authorRepo.findAll();
	}
	
	@Override
	public Author saveOrUpdateAuthor(Author author) {
		return authorRepo.save(author);
	}
	
	@Override
	public void deleteAuthorById(int id) {
		
		Optional<Author> existingAuthor = authorRepo.findById(id);
		
		if(existingAuthor.isPresent()) {
			authorRepo.deleteById(id);
		}
		
		else {
			System.out.println("The entered id number "+id+" is incorrect...!");
		}
	}
}
