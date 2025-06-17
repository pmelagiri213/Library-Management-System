package com.jspider.LibraryManagementSystem1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.LibraryManagementSystem1.Entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	
}