package com.microservices.banking.cards.service.project.service;

import java.util.List;

import com.microservices.banking.cards.service.project.dto.CardsRequest;
import com.microservices.banking.cards.service.project.dto.CardsResponse;
import com.microservices.banking.cards.service.project.entity.Cards;

public interface CardService 
{

	List<Cards> getCardsDetailsByCardType(String cardType);

	CardsResponse getCardDetailsByCardNumber(String cardNumber);

	Cards saveNewCardsDetailsForCustomer(CardsRequest cardsRequest);
	
	List<CardsResponse> getAllCardDetails(Long customerId);
}
