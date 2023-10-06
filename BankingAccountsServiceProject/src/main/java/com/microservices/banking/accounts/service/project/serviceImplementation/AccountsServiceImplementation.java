package com.microservices.banking.accounts.service.project.serviceImplementation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.banking.accounts.service.project.dto.AccountsRequest;
import com.microservices.banking.accounts.service.project.dto.AccountsResponse;
import com.microservices.banking.accounts.service.project.dto.ApiResponse;
import com.microservices.banking.accounts.service.project.dto.CardsResponse;
import com.microservices.banking.accounts.service.project.dto.CustomerRequest;
import com.microservices.banking.accounts.service.project.dto.CustomerResponse;
import com.microservices.banking.accounts.service.project.dto.LoansResponse;
import com.microservices.banking.accounts.service.project.entity.Accounts;
import com.microservices.banking.accounts.service.project.entity.Customers;
import com.microservices.banking.accounts.service.project.exception.AccountAlreadyExistException;
import com.microservices.banking.accounts.service.project.exception.AccountNotFoundException;
import com.microservices.banking.accounts.service.project.exception.CustomerNotFoundException;
import com.microservices.banking.accounts.service.project.feignClient.CardsService;
import com.microservices.banking.accounts.service.project.feignClient.LoansService;
import com.microservices.banking.accounts.service.project.mapper.AccountsCustomerMapper;
import com.microservices.banking.accounts.service.project.repository.AccountsRepository;
import com.microservices.banking.accounts.service.project.repository.CustomersRepository;
import com.microservices.banking.accounts.service.project.service.AccountsService;

@Service
public class AccountsServiceImplementation implements AccountsService
{
	Logger accountsServiceLogger = LoggerFactory.getLogger(AccountsServiceImplementation.class);
	
	@Autowired
	private AccountsRepository accountsRepository;
	
	@Autowired
	private CustomersRepository customersRepository;
	
	@Autowired
	private CardsService cardsService;
	
	@Autowired
	private LoansService loansService;

	@Override
	public Customers saveNewCustomer(CustomerRequest customerRequest)
	{
		accountsServiceLogger.info("Saving new cutsomer to the database -- service layer");
		Customers customers = AccountsCustomerMapper.customersRequestMapToCustomers(customerRequest);
		
		Customers savedCustomer = customersRepository.save(customers);
		
		return savedCustomer;	
	}
	
	@Override
	public CustomerResponse getCustomerById(Long customerId)
	{
		accountsServiceLogger.info("get customer details from the database for the entered customer id -- service layer");
		Customers customers = customersRepository.findById(customerId).get();
		
		if(customers == null)
		{
			throw new CustomerNotFoundException("Customer not exist with given cutsomer id : "+customerId);
		}
		
		CustomerResponse customerResponse = AccountsCustomerMapper.customersMapToCustomerResponse(customers);
		
		return customerResponse;	
	}
	
	@Override
	public Accounts saveNewAccountForCustomer(AccountsRequest accountsRequest)
	{
		accountsServiceLogger.info("Saving new account of the customer -- service layer");
		Accounts accounts = accountsRepository.findByAccountNumber(accountsRequest.getAccountNumber());
		
		if(accounts != null)
		{
			throw new AccountAlreadyExistException("Account with entered account number "+accountsRequest.getAccountNumber()+" already exist");
		}
		
		Accounts acc = AccountsCustomerMapper.accountsRequestMapToAccounts(accountsRequest);
		Accounts savedAccount = accountsRepository.save(acc);
		return savedAccount;	
	}
	
	@Override
	public AccountsResponse getAccountByAccountNumber(Long accountNumber)
	{
		accountsServiceLogger.info("Get account details from the database for the entered account number -- service layer");
		Accounts accounts = accountsRepository.findByAccountNumber(accountNumber);
		
		if(accounts == null)
		{
			throw new AccountNotFoundException("account details not found for the account number : "+accountNumber);
		}
		AccountsResponse accountsResponse = AccountsCustomerMapper.accountMapToAccountsResponse(accounts);
		
		return accountsResponse;	
	}
	
	@Override
	public List<AccountsResponse> getAllAccountByCustomerId(Long customerId)
	{
		accountsServiceLogger.info("Get account details of the customer from the database for the entered customer id -- service layer");
		List<Accounts> accountsList = accountsRepository.findByCustomerId(customerId);
		
		if(accountsList == null)
		{
			throw new AccountNotFoundException("account details not found for the customer Id : "+customerId);
		}
		List<AccountsResponse> accountsResponseList = new ArrayList<>();
		
		for(Accounts acc: accountsList)
		{
			AccountsResponse accRes = new AccountsResponse();
			accRes.setAccountsId(acc.getAccountsId());
			accRes.setCustomerId(acc.getCustomerId());
			accRes.setAccountNumber(acc.getAccountNumber());
			accRes.setAccountType(acc.getAccountType());
			accRes.setBranchAddress(acc.getBranchAddress());
			accRes.setAccountCreatedDate(acc.getAccountCreatedDate());
			
			accountsResponseList.add(accRes);
		}
		return accountsResponseList;	
	}
	
	@Override
	public ApiResponse getAllDetailsOfCustomer(Long customerId)
	{
		accountsServiceLogger.info("Get all details of the customer from the database for the entered customer id -- service layer");
		List<AccountsResponse> accountsResponseList = getAllAccountByCustomerId(customerId);
		
		CustomerResponse customerDetails = getCustomerById(customerId);
		
		List<CardsResponse> cardsResponseList = cardsService.getAllCardDetails(customerId);
		
		List<LoansResponse> loansResponseList = loansService.getAllLoanDetails(customerId);
		
		ApiResponse apiResponse = new ApiResponse();
		
		apiResponse.setCustomerResponse(customerDetails);
		
		apiResponse.setAccountsList(accountsResponseList);
		
		apiResponse.setCardsList(cardsResponseList);
		
		apiResponse.setLoansList(loansResponseList);
		
		return apiResponse;	
	}
}
