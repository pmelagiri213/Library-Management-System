package com.jspider.LibraryManagementSystem1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspider.LibraryManagementSystem1.Entity.Card;

public interface CardRepository extends JpaRepository<Card, Integer> {

}
