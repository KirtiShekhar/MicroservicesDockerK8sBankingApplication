package com.microservices.banking.accounts.service.project.exception;

public class AccountAlreadyExistException extends RuntimeException
{	
	private static final long serialVersionUID=1L;
	
	public AccountAlreadyExistException(String message)
	{
		super(message);
	}
}