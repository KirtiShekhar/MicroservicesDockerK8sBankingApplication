package com.microservices.banking.loans.service.project.controller;

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
import com.microservices.banking.loans.service.project.dto.LoansRequest;
import com.microservices.banking.loans.service.project.dto.LoansResponse;
import com.microservices.banking.loans.service.project.entity.Loans;
import com.microservices.banking.loans.service.project.service.LoansService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/loans")
public class LoansController 
{
	Logger loansControllerLogger = LoggerFactory.getLogger(LoansController.class);
	
	@Autowired
	private LoansService loansService;
	
	@PostMapping("saveLoan")
	@Operation(summary = "Saving new Loan Details of the customer")
	public ResponseEntity<?> saveNewLoanDetailsForCustomer(@RequestBody LoansRequest loansRequest)
	{
		loansControllerLogger.info("Saving new Loan Details of the customer -- controller layer");
		
		Loans loansDetails = loansService.saveNewLoanDetailsForCustomer(loansRequest);
		
		return new ResponseEntity<>(loansDetails,HttpStatus.CREATED);
	}
	
	@GetMapping("getLoanDetails/type")
	@Operation(summary = "Get loan details from the database for the entered loan type")
	public ResponseEntity<?> getLoanDetailsByLoanType(@RequestParam String loanType)
	{
		loansControllerLogger.info("Get loan details from the database for the entered loan type -- controller layer");
		
		List<Loans> loansDetailsListResponse = loansService.getLoanDetailsByLoanType(loanType);
		
		return new ResponseEntity<>(loansDetailsListResponse,HttpStatus.OK);
	}
	
	
	@GetMapping("getAllLoanDetails/type")
	@Operation(summary = "Get All loan details from the database for the entered customer Id")
	public ResponseEntity<?> getAllLoanDetails(Long customerId)
	{
		loansControllerLogger.info("Get loan details from the database for the entered customer Id -- controller layer");
		
		List<LoansResponse> loansDetailsListResponse = loansService.getAllLoanDetails(customerId);
		
		return new ResponseEntity<>(loansDetailsListResponse,HttpStatus.OK);
	}
}
