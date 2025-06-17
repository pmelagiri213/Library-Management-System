package com.jspider.LibraryManagementSystem1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.LibraryManagementSystem1.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}