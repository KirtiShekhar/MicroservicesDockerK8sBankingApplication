package com.microservices.banking.cards.service.project.entity;

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
@Table(name = "microservices_banking_cards")
public class Cards 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cards_id")
	private Long cardsId;
	@Column(name = "customer_id")
	private Long customerId;
	@Column(name = "card_number")
	private String cardNumber;
	@Column(name = "card_type")
	private String cardType;
	@Column(name = "card_total_limit")
	private Long totalLimit;
	@Column(name = "amount_used")
	private Integer amountUsed;
	@Column(name = "available_amount")
	private Integer availableAmount;
	@Column(name = "card_created_date")
	private LocalDateTime cardCreatedDate;
}
