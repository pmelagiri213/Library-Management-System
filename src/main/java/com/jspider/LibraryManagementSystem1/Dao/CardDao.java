package com.jspider.LibraryManagementSystem1.Dao;

import java.util.List;
import java.util.Optional;

import com.jspider.LibraryManagementSystem1.Entity.Card;

public interface CardDao {
	Optional<Card> getCardById(int id);
	List<Card> getAllCards();
	Card saveOrUpdateCard(Card card);
	void deleteCardById(int id);
}
