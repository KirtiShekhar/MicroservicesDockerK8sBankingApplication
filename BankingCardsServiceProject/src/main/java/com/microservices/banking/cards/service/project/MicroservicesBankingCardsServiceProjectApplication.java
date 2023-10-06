package com.microservices.banking.cards.service.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "microservices-banking-cards-service-project", version = "2.0", description = "Spring Boot Application Microservices cards services project for banking application"))
public class MicroservicesBankingCardsServiceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesBankingCardsServiceProjectApplication.class, args);
		System.out.println("Running application Microservices Banking Cards Service Project !");
	}

}
