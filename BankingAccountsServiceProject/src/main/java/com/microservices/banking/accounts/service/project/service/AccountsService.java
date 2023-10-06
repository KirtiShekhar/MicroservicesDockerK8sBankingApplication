package com.microservices.banking.accounts.service.project.service;

import java.util.List;

import com.microservices.banking.accounts.service.project.dto.AccountsRequest;
import com.microservices.banking.accounts.service.project.dto.AccountsResponse;
import com.microservices.banking.accounts.service.project.dto.ApiResponse;
import com.microservices.banking.accounts.service.project.dto.CustomerRequest;
import com.microservices.banking.accounts.service.project.dto.CustomerResponse;
import com.microservices.banking.accounts.service.project.entity.Accounts;
import com.microservices.banking.accounts.service.project.entity.Customers;

public interface AccountsService {

	AccountsResponse getAccountByAccountNumber(Long accountNumber);

	Accounts saveNewAccountForCustomer(AccountsRequest accountsRequest);

	CustomerResponse getCustomerById(Long customerId);

	Customers saveNewCustomer(CustomerRequest customerRequest);
	
	List<AccountsResponse> getAllAccountByCustomerId(Long customerId);
	
	ApiResponse getAllDetailsOfCustomer(Long customerId);

}
