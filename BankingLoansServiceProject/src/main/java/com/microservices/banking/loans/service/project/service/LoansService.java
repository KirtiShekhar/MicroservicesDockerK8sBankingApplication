package com.microservices.banking.loans.service.project.service;

import java.util.List;

import com.microservices.banking.loans.service.project.dto.LoansRequest;
import com.microservices.banking.loans.service.project.dto.LoansResponse;
import com.microservices.banking.loans.service.project.entity.Loans;

public interface LoansService {

	List<Loans> getLoanDetailsByLoanType(String loanType);

	Loans saveNewLoanDetailsForCustomer(LoansRequest loansRequest);
	
	List<LoansResponse> getAllLoanDetails(Long customerId);
}
