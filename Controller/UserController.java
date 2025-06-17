package com.jspider.LibraryManagementSystem1.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.LibraryManagementSystem1.Entity.User;
import com.jspider.LibraryManagementSystem1.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	//Get all the User records
	@GetMapping
	public ResponseEntity<List<User>> getAllTheUsers(){
		List<User> users = userService.getAllUsers();
		
		return ResponseEntity.ok(users);
	}
	
	
	//Get a particular User by User Id
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		
		Optional<User> user = userService.getUserRecordById(id);
		
		if(user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	//Save The User record
	public ResponseEntity<User> savePublisherRecord(@RequestBody User user){
		
		User createdUser = userService.saveOrUpdate(user);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}
	
	
	//Update a particular User record by User Id
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUserRecordById(@RequestBody User user, @PathVariable int id){
		
		Optional<User> existingUser = userService.getUserRecordById(id);
		
		if(existingUser.isPresent()) {
			user.setUserId(id);
			userService.saveOrUpdate(user);
			return ResponseEntity.ok(user);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	//Delete a particular record by User Id
	public ResponseEntity<User> deleteUserRecord(@PathVariable int id){
		
		if(userService.getUserRecordById(id).isPresent()) {
			
			userService.deleteUserById(id);
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
