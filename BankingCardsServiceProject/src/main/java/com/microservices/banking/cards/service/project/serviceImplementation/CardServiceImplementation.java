package com.microservices.banking.cards.service.project.serviceImplementation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservices.banking.cards.service.project.dto.CardsRequest;
import com.microservices.banking.cards.service.project.dto.CardsResponse;
import com.microservices.banking.cards.service.project.entity.Cards;
import com.microservices.banking.cards.service.project.exception.CardDetailsNotFoundException;
import com.microservices.banking.cards.service.project.mapper.CardsMapper;
import com.microservices.banking.cards.service.project.repository.CardsRepository;
import com.microservices.banking.cards.service.project.service.CardService;

@Service
public class CardServiceImplementation implements CardService
{
	Logger cardsServiceLogger = LoggerFactory.getLogger(CardServiceImplementation.class);
	
	@Autowired
	private CardsRepository cardsRepository;
	
	@Override
	public Cards saveNewCardsDetailsForCustomer(CardsRequest cardsRequest)
	{
		cardsServiceLogger.info("Saving new Card Details of the customer -- service layer");
		
		Cards cards = CardsMapper.cardsRequestMapToCards(cardsRequest);
		
		Cards savedCardDetail = cardsRepository.save(cards);
		return savedCardDetail;	
	}
	
	@Override
	public CardsResponse getCardDetailsByCardNumber(String cardNumber)
	{
		cardsServiceLogger.info("Get loan details of the customer from the database for the entered customer Id -- service layer");
		Cards cards = cardsRepository.findByCardNumber(cardNumber).get();
		
		if(cards == null)
		{
			throw new CardDetailsNotFoundException("Loan details not found for the entered card number : "+cardNumber);
		}
		
		CardsResponse cardsResponse = CardsMapper.cardsMapToCardsResponse(cards);
		
		return cardsResponse;	
	}
	
	@Override
	public List<Cards> getCardsDetailsByCardType(String cardType)
	{
		cardsServiceLogger.info("Get card details from the database for the entered card type -- service layer");
		List<Cards> cardsDetails = cardsRepository.findByCardType(cardType);
		
		if(cardsDetails.isEmpty())
		{
			throw new CardDetailsNotFoundException("Card details not found for the entered card type : "+cardType);
		}
		
		return cardsDetails;	
	}
	
	@Override
	public List<CardsResponse> getAllCardDetails(Long customerId)
	{
		cardsServiceLogger.info("Get card details from the database for the entered card type -- service layer");
		List<Cards> cardsDetails = cardsRepository.findByCustomerId(customerId);
		
		if(cardsDetails.isEmpty())
		{
			throw new CardDetailsNotFoundException("Card details not found for the entered customer Id : "+customerId);
		}
		
		List<CardsResponse> cardsResponseList = new ArrayList<CardsResponse>();
		
		for(Cards cards: cardsDetails)
		{
			CardsResponse cardsRes = new CardsResponse();
			cardsRes.setCardsId(cards.getCardsId());
			cardsRes.setCustomerId(cards.getCustomerId());
			cardsRes.setCardNumber(cards.getCardNumber());
			cardsRes.setCardType(cards.getCardType());
			cardsRes.setTotalLimit(cards.getTotalLimit());
			cardsRes.setAmountUsed(cards.getAmountUsed());
			cardsRes.setAvailableAmount(cards.getAvailableAmount());
			cardsRes.setCardCreatedDate(cards.getCardCreatedDate());
			
			cardsResponseList.add(cardsRes);
		}
		
		return cardsResponseList;	
	}

}
