package com.jspider.LibraryManagementSystem1.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.LibraryManagementSystem1.DaoImpl.CardDaoImpl;
import com.jspider.LibraryManagementSystem1.Entity.Card;

@Service
public class CardService {
	
	@Autowired
	private CardDaoImpl cardDaoImpl;
	
	
	//Get all the Card Records
	public List<Card> getAllCards(){
		return cardDaoImpl.getAllCards();
	}
	
	
	//Get Card record by Id
	public Optional<Card> getCardById(int id){
		return cardDaoImpl.getCardById(id);
	}
	
	
	//Save or Update the Card Record
	public Card saveOrUpdate(Card card) {
		return cardDaoImpl.saveOrUpdateCard(card);
	}
	
	
	//Delete a Card record by Id
	public void deleteCardById(int id){
		cardDaoImpl.deleteCardById(id);
	}
}
