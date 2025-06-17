package com.jspider.LibraryManagementSystem1.DaoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspider.LibraryManagementSystem1.Dao.CardDao;
import com.jspider.LibraryManagementSystem1.Entity.Card;
import com.jspider.LibraryManagementSystem1.Repository.CardRepository;

@Repository
public class CardDaoImpl implements CardDao {
	
	@Autowired
	private CardRepository cardRepo;
	
	@Override
	public Optional<Card> getCardById(int id){
		return cardRepo.findById(id);
	}
	
	@Override
	public List<Card> getAllCards(){
		return cardRepo.findAll();
	}
	
	@Override
	public Card saveOrUpdateCard(Card card) {
		return cardRepo.save(card);
	}
	
	@Override
	public void deleteCardById(int id) {
		
		Optional<Card> existingCard = cardRepo.findById(id);
		
		if(existingCard.isPresent()) {
			cardRepo.deleteById(id);
		}
		
		else {
			System.out.println("The entered id number "+id+" id incorrect...!");
		}
	}
}
