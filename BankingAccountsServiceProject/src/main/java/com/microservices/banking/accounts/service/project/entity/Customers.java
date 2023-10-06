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
@Table(name = "microservices_banking_customers")
public class Customers 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private Long customerId;
	@Column(name = "customer_name")
	private String customerName;
	@Column(name = "customer_email_address",columnDefinition = "text")
	private String customerEmailAddress;
	@Column(name = "customer_contact_number")
	private String customerContactNumber;
	@Column(name = "customer_created_date")
	private LocalDateTime createDate;
}
