package com.microservices.banking.accounts.service.project.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse 
{
	private CustomerResponse customerResponse;
	private List<AccountsResponse> accountsList;
	private List<CardsResponse> cardsList;
	private List<LoansResponse> loansList;
}
