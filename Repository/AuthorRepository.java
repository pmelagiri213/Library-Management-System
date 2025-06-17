package com.jspider.LibraryManagementSystem1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.LibraryManagementSystem1.Entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
	
}
