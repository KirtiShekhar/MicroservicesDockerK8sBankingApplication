package com.microservices.banking.loans.service.project.serviceImplementation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.banking.loans.service.project.dto.LoansRequest;
import com.microservices.banking.loans.service.project.dto.LoansResponse;
import com.microservices.banking.loans.service.project.entity.Loans;
import com.microservices.banking.loans.service.project.exception.LoanNotFoundException;
import com.microservices.banking.loans.service.project.mapper.LoansMapper;
import com.microservices.banking.loans.service.project.repository.LoansRepository;
import com.microservices.banking.loans.service.project.service.LoansService;

@Service
public class LoansServiceImplementation implements LoansService
{
	Logger loansServiceLogger = LoggerFactory.getLogger(LoansServiceImplementation.class);
	
	@Autowired
	private LoansRepository loansRepository;
	
	@Override
	public Loans saveNewLoanDetailsForCustomer(LoansRequest loansRequest)
	{
		loansServiceLogger.info("Saving new Loan Details of the customer -- service layer");
		
		Loans loans = LoansMapper.loansRequestMapToLoans(loansRequest);
		
		Loans savedLoanDetail = loansRepository.save(loans);
		return savedLoanDetail;	
	}
	
	@Override
	public List<Loans> getLoanDetailsByLoanType(String loanType)
	{
		loansServiceLogger.info("Get loan details from the database for the entered loan type -- service layer");
		List<Loans> loansDetails = loansRepository.findByLoanType(loanType);
		
		if(loansDetails.isEmpty())
		{
			throw new LoanNotFoundException("Loan details not found for the entered loan type : "+loanType);
		}
		
		return loansDetails;	
	}
	
	@Override
	public List<LoansResponse> getAllLoanDetails(Long customerId)
	{
		loansServiceLogger.info("Get All loan details from the database for the entered loan type -- service layer");
		List<Loans> loansDetails = loansRepository.findByCustomerId(customerId);
		
		if(loansDetails.isEmpty())
		{
			throw new LoanNotFoundException("Loan details not found for the entered customer Id : "+customerId);
		}
		
		List<LoansResponse> loansResponseList = new ArrayList<LoansResponse>();
		
		for(Loans loans: loansDetails)
		{
			LoansResponse loansRes = new LoansResponse();
			loansRes.setLoanId(loans.getLoanId());
			loansRes.setCustomerId(loans.getCustomerId());
			loansRes.setLoanType(loans.getLoanType());
			loansRes.setTotalLoanAmount(loans.getTotalLoanAmount());
			loansRes.setOutstandingAmount(loans.getOutstandingAmount());
			loansRes.setAmountPaid(loans.getAmountPaid());
			loansRes.setLoanStartDate(loans.getLoanStartDate());
			loansRes.setLoanEndDate(loans.getLoanEndDate());
			
			loansResponseList.add(loansRes);
		}
		
		return loansResponseList;
	}

}
