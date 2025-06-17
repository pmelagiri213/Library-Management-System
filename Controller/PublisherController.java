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

import com.jspider.LibraryManagementSystem1.Entity.Publisher;
import com.jspider.LibraryManagementSystem1.Service.PublisherService;

@RestController
@RequestMapping("/publisher")
public class PublisherController {
	
	@Autowired
	private PublisherService publisherService;
	
	
	//Get all Publishers record
	@GetMapping
	public ResponseEntity<List<Publisher>> getAllPublishers(){
		List<Publisher> publishers = publisherService.getAllPublisherRcords();
		
		return ResponseEntity.ok(publishers);
	}
	
	
	//Get particular Publisher record by Id
	@GetMapping("/{id}")
	public ResponseEntity<Publisher> getPublisherById(@PathVariable int id){
		
		Optional<Publisher> publisher = publisherService.getPublisherById(id);
		
		if(publisher.isPresent()) {
			return ResponseEntity.ok(publisher.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	//Save the publisher record
	@PostMapping
	public ResponseEntity<Publisher> savePublisherRecord(@RequestBody Publisher publisher){
		Publisher createdPublisher = publisherService.saveOrUpdate(publisher);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createdPublisher);
	}
	
	
	//Update the Publisher record by Publisher Id
	@PutMapping("/{id}")
	public ResponseEntity<Publisher> updatePublisher(@RequestBody Publisher publisher, @PathVariable int id){
		
		Optional<Publisher> existingpublisher = publisherService.getPublisherById(id);
		
		if(existingpublisher.isPresent()) {
			
			publisher.setId(id);
			publisherService.saveOrUpdate(publisher);
			return ResponseEntity.ok(publisher);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	//Delete a particular Publisher record by the Id
	@DeleteMapping("/{Id}")
	public ResponseEntity<Publisher> deletePublisherById(@PathVariable int id){
		
		if(publisherService.getPublisherById(id).isPresent()) {
			
			publisherService.deletePublisherRecordById(id);
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
