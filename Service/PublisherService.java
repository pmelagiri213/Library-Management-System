package com.jspider.LibraryManagementSystem1.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.LibraryManagementSystem1.DaoImpl.PublisherDaoImpl;
import com.jspider.LibraryManagementSystem1.Entity.Publisher;

@Service
public class PublisherService {
	
	@Autowired
	private PublisherDaoImpl publisherDaoImpl;
	
	
	//Get all Publisher Records
	public List<Publisher> getAllPublisherRcords(){
		return publisherDaoImpl.getAllPublishers();
	}
	
	
	//Get Publisher record by Publisher Id
	public Optional<Publisher> getPublisherById(int id) {
		return publisherDaoImpl.getPublisherById(id);
	}
	
	
	//Save or Update Publisher Record
	public Publisher saveOrUpdate(Publisher publisher) {
		return publisherDaoImpl.saveOrUpdatePublisher(publisher);
	}
	
	
	//Delete a Publisher record by Publisher Id
	public void deletePublisherRecordById(int id) {
		publisherDaoImpl.deletePublisherById(id);
	}
}
