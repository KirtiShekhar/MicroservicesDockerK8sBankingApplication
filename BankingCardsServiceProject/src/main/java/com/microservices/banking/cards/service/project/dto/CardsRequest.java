package com.microservices.banking.cards.service.project.dto;

import java.time.LocalDateTime;

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
public class CardsRequest 
{
	private Long customerId;
	private String cardNumber;
	private String cardType;
	private Long totalLimit;
	private Integer amountUsed;
	private Integer availableAmount;
	private LocalDateTime cardCreatedDate;
}
