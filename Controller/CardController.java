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

import com.jspider.LibraryManagementSystem1.Entity.Card;
import com.jspider.LibraryManagementSystem1.Service.CardService;

@RestController
@RequestMapping("/card")
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	
	//Get all the Card records
	@GetMapping
	public ResponseEntity<List<Card>> getAllCardRecords(){
		List<Card> cards =  cardService.getAllCards();
		return ResponseEntity.ok(cards);
	}
	
	
	//Get particular Card record by Card Id
	@GetMapping("/{id}")
	public ResponseEntity<Card> getCardById(@PathVariable int id){
		Optional<Card> card = cardService.getCardById(id);
		
		if(card.isPresent()) {
			return ResponseEntity.ok(card.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	//Save the Card record
	@PostMapping
	public ResponseEntity<Card> saveCardRecord(@RequestBody Card card){
		Card createdCard = cardService.saveOrUpdate(card);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(createdCard);
	}
	
	
	//Update the Card record
	@PutMapping("/{no}")
	public ResponseEntity<Card> updateCardRecord(@RequestBody Card card, @PathVariable int no){
		Optional<Card> existingCard = cardService.getCardById(no);
		
		if(existingCard.isPresent()) {
			card.setCardNo(no);
			cardService.saveOrUpdate(card);
			return ResponseEntity.ok(card);
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	
	//Delete particular Card record by Card no
	@DeleteMapping("/cardNo")
	public ResponseEntity<Card> deleteCardByNo(@PathVariable int cardNo){
		
		if(cardService.getCardById(cardNo).isPresent()) {
			
			cardService.deleteCardById(cardNo);
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
