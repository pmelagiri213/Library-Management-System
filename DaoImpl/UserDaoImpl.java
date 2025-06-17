package com.jspider.LibraryManagementSystem1.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.LibraryManagementSystem1.Dao.UserDao;
import com.jspider.LibraryManagementSystem1.Entity.User;
import com.jspider.LibraryManagementSystem1.Repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public Optional<User> getUserById(int id) {
		return userRepo.findById(id);
	}
	
	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	@Override
	public User saveOrUpdateUser(User user) {
		return userRepo.save(user);
	}
	
	@Override
	public void deleteUserById(int id) {
		
		Optional<User> existingUser = userRepo.findById(id);
		
		if(existingUser.isPresent()) {
			userRepo.deleteById(id);
		}
		
		else {
			System.out.println("The entered id number is "+id+" is incorrect...!");
		}
	}
}
