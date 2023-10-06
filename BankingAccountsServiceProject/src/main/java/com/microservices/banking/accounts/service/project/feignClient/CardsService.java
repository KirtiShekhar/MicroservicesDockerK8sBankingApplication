package com.microservices.banking.accounts.service.project.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.microservices.banking.accounts.service.project.dto.CardsResponse;

@FeignClient(name = "microservices-banking-cards-service-project")
public interface CardsService 
{
	@GetMapping("/api/cards/getAllCardDetails/customer")
	List<CardsResponse> getAllCardDetails(@RequestParam Long customerId);

}
