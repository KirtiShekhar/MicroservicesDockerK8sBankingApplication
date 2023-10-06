package com.microservices.banking.loans.service.project.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "microservices_banking_loans")
public class Loans 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "loan_id")
	private Long loanId;
	@Column(name = "customer_id")
	private Long customerId;
	@Column(name = "loan_type")
	private String loanType;
	@Column(name = "total_loan_amount")
	private Integer totalLoanAmount;
	@Column(name = "amount_paid")
	private Integer amountPaid;
	@Column(name = "outstanding_amount")
	private Integer outstandingAmount;
	@Column(name = "loan_start_date")
	private LocalDateTime loanStartDate;
	@Column(name = "loan_end_date")
	private LocalDateTime loanEndDate;
}