package com.microservices.banking.loans.service.project.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoansResponse
{
	private Long loanId;
	private Long customerId;
	private String loanType;
	private Integer totalLoanAmount;
	private Integer amountPaid;
	private Integer outstandingAmount;
	private LocalDateTime loanStartDate;
	private LocalDateTime loanEndDate;
}
