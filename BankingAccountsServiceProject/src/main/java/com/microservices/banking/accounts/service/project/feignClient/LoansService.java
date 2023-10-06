package com.microservices.banking.accounts.service.project.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservices.banking.accounts.service.project.dto.LoansResponse;

@FeignClient(name = "microservices-banking-loans-service-project")
public interface LoansService 
{
	@GetMapping("/api/loans/getAllLoanDetails/type")
	List<LoansResponse> getAllLoanDetails(@RequestParam Long customerId);
}
