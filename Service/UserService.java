package com.jspider.LibraryManagementSystem1.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.LibraryManagementSystem1.DaoImpl.UserDaoImpl;
import com.jspider.LibraryManagementSystem1.Entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	
	//Get all the User records
	public List<User> getAllUsers(){
		return userDaoImpl.getAllUsers();
	}
	
	
	//Get User record by User Id
	public Optional<User> getUserRecordById(int id){
		return userDaoImpl.getUserById(id);
	}
	
	
	//Save or Update the User record
	public User saveOrUpdate(User user) {
		return userDaoImpl.saveOrUpdateUser(user);
	}
	
	
	//Delete User record by User Id
	public void deleteUserById(int id) {
		userDaoImpl.deleteUserById(id);
	}
}
