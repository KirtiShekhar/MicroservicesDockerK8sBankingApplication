package com.microservices.banking.accounts.service.project.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountsRequest
{
	private Long customerId;
	private Long accountNumber;
	private String accountType;
	private String branchAddress;
	private LocalDateTime accountCreatedDate;

}
