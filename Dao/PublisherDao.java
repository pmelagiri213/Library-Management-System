package com.jspider.LibraryManagementSystem1.Dao;

import java.util.List;
import java.util.Optional;

import com.jspider.LibraryManagementSystem1.Entity.Publisher;


public interface PublisherDao {
	Optional<Publisher> getPublisherById(int id);
	List<Publisher> getAllPublishers();
	Publisher saveOrUpdatePublisher(Publisher publisher);
	void deletePublisherById(int id);
}
