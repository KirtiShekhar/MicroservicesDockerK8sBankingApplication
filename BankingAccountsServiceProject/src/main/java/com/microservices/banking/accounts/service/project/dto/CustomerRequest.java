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
public class CustomerRequest
{
	private String customerName;
	private String customerEmailAddress;
	private String customerContactNumber;
	private LocalDateTime createDate;
}
