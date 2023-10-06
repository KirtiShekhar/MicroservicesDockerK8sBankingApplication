package com.microservices.banking.accounts.service.project.exception;

public class CustomerAlreadyExistException extends RuntimeException
{	
	private static final long serialVersionUID=1L;
	
	public CustomerAlreadyExistException(String message)
	{
		super(message);
	}
}