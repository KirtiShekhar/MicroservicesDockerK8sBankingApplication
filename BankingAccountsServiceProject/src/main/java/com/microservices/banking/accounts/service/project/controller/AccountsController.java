package com.microservices.banking.accounts.service.project.controller;

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

import com.microservices.banking.accounts.service.project.dto.AccountsRequest;
import com.microservices.banking.accounts.service.project.dto.AccountsResponse;
import com.microservices.banking.accounts.service.project.dto.ApiResponse;
import com.microservices.banking.accounts.service.project.dto.CustomerRequest;
import com.microservices.banking.accounts.service.project.dto.CustomerResponse;
import com.microservices.banking.accounts.service.project.entity.Accounts;
import com.microservices.banking.accounts.service.project.entity.Customers;
import com.microservices.banking.accounts.service.project.service.AccountsService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController
{
	Logger accountsControllerLogger = LoggerFactory.getLogger(AccountsController.class);
	
	@Autowired
	private AccountsService accountsService;

	@PostMapping("saveCustomer")
	@Operation(summary = "Saving new cutsomer to the database")
	public ResponseEntity<?> saveNewCustomer(@RequestBody CustomerRequest customerRequest)
	{
		accountsControllerLogger.info("Saving new cutsomer to the database -- controller layer");
		Customers customers = accountsService.saveNewCustomer(customerRequest);
		
		return new ResponseEntity<>(customers,HttpStatus.CREATED);
	}
	
	@GetMapping("getCustomer")
	@Operation(summary = "Get customer details from the database for the entered customer id")
	public ResponseEntity<?> getCustomerById(@RequestParam Long customerId)
	{
		accountsControllerLogger.info("Get customer details from the database for the entered customer id -- controller layer");
		CustomerResponse customerResponse = accountsService.getCustomerById(customerId);
		
		return new ResponseEntity<>(customerResponse,HttpStatus.OK);	
	}
	
	@PostMapping("saveAccounts")
	@Operation(summary = "Saving new account of the customer")
	public ResponseEntity<?> saveNewAccountForCustomer(@RequestBody AccountsRequest accountsRequest)
	{
		accountsControllerLogger.info("Saving new account of the customer -- controller layer");
		Accounts accounts = accountsService.saveNewAccountForCustomer(accountsRequest);
		
		return new ResponseEntity<>(accounts,HttpStatus.CREATED);
	}
	
	@GetMapping("getAccountDetails/number")
	@Operation(summary = "Get account details from the database for the entered account number")
	public ResponseEntity<?> getAccountByAccountNumber(@RequestParam Long accountNumber)
	{
		accountsControllerLogger.info("Get account details from the database for the entered account number -- controller layer");
		AccountsResponse accountsResponse = accountsService.getAccountByAccountNumber(accountNumber);
		
		return new ResponseEntity<>(accountsResponse,HttpStatus.OK);	
	}
	
	@GetMapping("getAllAccountDetails/customer")
	@Operation(summary = "Get all account details of the customer from the database for the entered customer id")
	public ResponseEntity<?> getAllAccountByCustomerId(@RequestParam Long customerId)
	{
		accountsControllerLogger.info("Get all account details of the customer from the database for the entered customer id -- controller layer");
		List<AccountsResponse> accountsResponseList = accountsService.getAllAccountByCustomerId(customerId);
		
		return new ResponseEntity<>(accountsResponseList,HttpStatus.OK);	
	}
	
	@GetMapping("getAllDetails/customer")
	@Operation(summary = "Get all details of the customer from the database for the entered customer id")
	public ResponseEntity<?> getAllDetailsOfCustomer(@RequestParam Long customerId)
	{
		accountsControllerLogger.info("Get all details of the customer from the database for the entered customer id -- controller layer");
		ApiResponse detailsResponse = accountsService.getAllDetailsOfCustomer(customerId);
		
		return new ResponseEntity<>(detailsResponse,HttpStatus.OK);	
	}

}
