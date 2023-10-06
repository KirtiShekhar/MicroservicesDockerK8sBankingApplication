package com.microservices.banking.accounts.service.project.mapper;

import com.microservices.banking.accounts.service.project.dto.AccountsRequest;
import com.microservices.banking.accounts.service.project.dto.AccountsResponse;
import com.microservices.banking.accounts.service.project.dto.CustomerRequest;
import com.microservices.banking.accounts.service.project.dto.CustomerResponse;
import com.microservices.banking.accounts.service.project.entity.Accounts;
import com.microservices.banking.accounts.service.project.entity.Customers;

public class AccountsCustomerMapper 
{
	public static Customers customersRequestMapToCustomers(CustomerRequest customerRequest)
	{
		Customers customers = new Customers();
		customers.setCustomerName(customerRequest.getCustomerName());
		customers.setCustomerEmailAddress(customerRequest.getCustomerEmailAddress());
		customers.setCustomerContactNumber(customerRequest.getCustomerContactNumber());
		customers.setCreateDate(customerRequest.getCreateDate());
		return customers;
	}
	
	public static Accounts accountsRequestMapToAccounts(AccountsRequest accountsRequest)
	{
		Accounts accounts = new Accounts();
		accounts.setCustomerId(accountsRequest.getCustomerId());
		accounts.setAccountNumber(accountsRequest.getAccountNumber());
		accounts.setAccountType(accountsRequest.getAccountType());
		accounts.setBranchAddress(accountsRequest.getBranchAddress());
		accounts.setAccountCreatedDate(accountsRequest.getAccountCreatedDate());
		return accounts;
	}
	
	public static CustomerResponse customersMapToCustomerResponse(Customers customers)
	{
		CustomerResponse customerResponse = new CustomerResponse();
		customerResponse.setCustomerId(customers.getCustomerId());
		customerResponse.setCustomerName(customers.getCustomerName());
		customerResponse.setCustomerEmailAddress(customers.getCustomerEmailAddress());
		customerResponse.setCustomerContactNumber(customers.getCustomerContactNumber());
		customerResponse.setCreateDate(customers.getCreateDate());
		return customerResponse;
	}
	
	public static AccountsResponse accountMapToAccountsResponse(Accounts accounts)
	{
		AccountsResponse accountsResponse = new AccountsResponse();
		accountsResponse.setAccountsId(accounts.getAccountsId());
		accountsResponse.setCustomerId(accounts.getCustomerId());
		accountsResponse.setAccountNumber(accounts.getAccountNumber());
		accountsResponse.setAccountType(accounts.getAccountType());
		accountsResponse.setBranchAddress(accounts.getBranchAddress());
		accountsResponse.setAccountCreatedDate(accounts.getAccountCreatedDate());
		return accountsResponse;
	}
}
