package com.microservices.banking.loans.service.project.mapper;

import com.microservices.banking.loans.service.project.dto.LoansRequest;
import com.microservices.banking.loans.service.project.dto.LoansResponse;
import com.microservices.banking.loans.service.project.entity.Loans;

public class LoansMapper 
{
	public static Loans loansRequestMapToLoans(LoansRequest loansRequest)
	{
		Loans loans = new Loans();
		loans.setCustomerId(loansRequest.getCustomerId());
		loans.setLoanType(loansRequest.getLoanType());
		loans.setTotalLoanAmount(loansRequest.getTotalLoanAmount());
		loans.setAmountPaid(loansRequest.getAmountPaid());
		loans.setOutstandingAmount(loansRequest.getOutstandingAmount());
		loans.setLoanStartDate(loansRequest.getLoanStartDate());
		loans.setLoanEndDate(loansRequest.getLoanEndDate());
		return loans;
	}
	
	public static LoansResponse loansMapToLoansResponse(Loans loans)
	{
		LoansResponse loansResponse = new LoansResponse();
		loansResponse.setLoanId(loans.getLoanId());
		loansResponse.setCustomerId(loans.getCustomerId());
		loansResponse.setLoanType(loans.getLoanType());
		loansResponse.setTotalLoanAmount(loans.getTotalLoanAmount());
		loansResponse.setAmountPaid(loans.getAmountPaid());
		loansResponse.setOutstandingAmount(loans.getOutstandingAmount());
		loansResponse.setLoanStartDate(loans.getLoanStartDate());
		loansResponse.setLoanEndDate(loans.getLoanEndDate());
		return loansResponse;
	}
}
