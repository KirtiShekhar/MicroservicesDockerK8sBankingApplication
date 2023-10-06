package com.microservices.banking.accounts.service.project.entity;

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
@Table(name = "microservices_banking_accounts")
public class Accounts 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "accounts_id")
	private Long accountsId;
	@Column(name = "customer_id")
	private Long customerId;
	@Column(name = "account_number")
	private Long accountNumber;
	@Column(name = "account_type")
	private String accountType;
	@Column(name = "branch_address")
	private String branchAddress;
	@Column(name = "account_create_date")
	private LocalDateTime accountCreatedDate;

}
