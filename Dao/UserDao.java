package com.jspider.LibraryManagementSystem1.Dao;

import java.util.List;
import java.util.Optional;

import com.jspider.LibraryManagementSystem1.Entity.User;


public interface UserDao {
	Optional<User> getUserById(int id);
	List<User> getAllUsers();
	User saveOrUpdateUser(User user);
	void deleteUserById(int id);
}
