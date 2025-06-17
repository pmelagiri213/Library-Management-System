package com.jspider.LibraryManagementSystem1.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.LibraryManagementSystem1.Dao.PublisherDao;
import com.jspider.LibraryManagementSystem1.Entity.Publisher;
import com.jspider.LibraryManagementSystem1.Repository.PublisherRepository;

@Repository
public class PublisherDaoImpl implements PublisherDao {
	
	@Autowired
	private PublisherRepository publisherRepo;
	
	@Override
	public Optional<Publisher> getPublisherById(int id){
		return publisherRepo.findById(id);
	}
	
	@Override
	public List<Publisher> getAllPublishers(){
		return publisherRepo.findAll();
	}
	
	@Override
	public Publisher saveOrUpdatePublisher(Publisher publisher) {
		return publisherRepo.save(publisher);
	}
	
	@Override
	public void deletePublisherById(int id) {
		
		Optional<Publisher> existingPublisher = publisherRepo.findById(id);
		
		if(existingPublisher.isPresent()) {
			publisherRepo.deleteById(id);
		}
		
		else {
			System.out.println("The entered id number is "+id+" is incorrect...!");
		}
	}
}
