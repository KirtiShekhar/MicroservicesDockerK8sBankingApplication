package com.microservices.banking.cards.service.project.exception;

public class CardDetailsNotFoundException extends RuntimeException
{	
	private static final long serialVersionUID=1L;
	
	public CardDetailsNotFoundException(String message)
	{
		super(message);
	}
}