package com.microservices.banking.cards.service.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.banking.cards.service.project.dto.CardsRequest;
import com.microservices.banking.cards.service.project.dto.CardsResponse;
import com.microservices.banking.cards.service.project.entity.Cards;
import com.microservices.banking.cards.service.project.service.CardService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/cards")
public class CardsController 
{
	Logger cardsControllerLogger = LoggerFactory.getLogger(CardsController.class);
	
	@Autowired
	private CardService cardService;
	
	@PostMapping("saveCard")
	@Operation(summary = "Saving new Card Details of the customer")
	public ResponseEntity<?> saveNewCardsDetailsForCustomer(@RequestBody CardsRequest cardRequest)
	{
		cardsControllerLogger.info("Saving new Card Details of the customer -- controller layer");
		
		Cards cards = cardService.saveNewCardsDetailsForCustomer(cardRequest);
		
		return new ResponseEntity<>(cards,HttpStatus.CREATED);	
	}
	
	@GetMapping("getCardDetails/number")
	@Operation(summary = "Get card details from the database for the entered card number")
	public ResponseEntity<?> getCardDetailsByCardNumber(@RequestParam String cardNumber)
	{
		cardsControllerLogger.info("Get card details from the database for the entered card number -- controller layer");
		
		CardsResponse cardsResponse = cardService.getCardDetailsByCardNumber(cardNumber);
		
		return new ResponseEntity<>(cardsResponse,HttpStatus.OK);
	}
	
	@GetMapping("getCardDetails/type")
	@Operation(summary = "Get card details from the database for the entered card type")
	public ResponseEntity<?> getCardsDetailsByCardType(@RequestParam String cardType)
	{
		cardsControllerLogger.info("Get card details from the database for the entered card type -- controller layer");
		
		List<Cards> cardsDetails = cardService.getCardsDetailsByCardType(cardType);
		
		return new ResponseEntity<>(cardsDetails,HttpStatus.FOUND);	
	}
	
	@GetMapping("getAllCardDetails/customer")
	@Operation(summary = "Get list of card details of the customer from the database for the entered customer Id")
	public ResponseEntity<?> getAllCardDetails(@RequestParam Long customerId)
	{
		cardsControllerLogger.info("Get list of card details of the customer from the database for the entered customer Id -- controller layer");
		
		List<CardsResponse> cardsResponse = cardService.getAllCardDetails(customerId);
		
		return new ResponseEntity<>(cardsResponse,HttpStatus.OK);	
	}

}
