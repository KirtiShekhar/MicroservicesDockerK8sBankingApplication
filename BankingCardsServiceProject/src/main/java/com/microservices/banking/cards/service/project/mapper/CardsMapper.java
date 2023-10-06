package com.microservices.banking.cards.service.project.mapper;

import com.microservices.banking.cards.service.project.dto.CardsRequest;
import com.microservices.banking.cards.service.project.dto.CardsResponse;
import com.microservices.banking.cards.service.project.entity.Cards;

public class CardsMapper
{
	public static Cards cardsRequestMapToCards(CardsRequest cardsRequest)
	{
		Cards cards = new Cards();
		cards.setCustomerId(cardsRequest.getCustomerId());
		cards.setCardNumber(cardsRequest.getCardNumber());
		cards.setCardType(cardsRequest.getCardType());
		cards.setTotalLimit(cardsRequest.getTotalLimit());
		cards.setAmountUsed(cardsRequest.getAmountUsed());
		cards.setAvailableAmount(cardsRequest.getAvailableAmount());
		cards.setCardCreatedDate(cardsRequest.getCardCreatedDate());
		return cards;
	}
	
	public static CardsResponse cardsMapToCardsResponse(Cards cards)
	{
		CardsResponse cardsResponse = new CardsResponse();
		cardsResponse.setCardsId(cards.getCardsId());
		cardsResponse.setCustomerId(cards.getCustomerId());
		cardsResponse.setCardNumber(cards.getCardNumber());
		cardsResponse.setCardType(cards.getCardType());
		cardsResponse.setTotalLimit(cards.getTotalLimit());
		cardsResponse.setAmountUsed(cards.getAmountUsed());
		cardsResponse.setAvailableAmount(cards.getAvailableAmount());
		cardsResponse.setCardCreatedDate(cards.getCardCreatedDate());
		return cardsResponse;
	}
}
