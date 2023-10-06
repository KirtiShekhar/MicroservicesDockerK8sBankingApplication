package com.microservices.banking.loans.service.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "microservices-banking-loans-service-project", version = "2.0", description = "Spring Boot Application Microservices loans services project for banking application"))
public class MicroservicesBankingLoansServiceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesBankingLoansServiceProjectApplication.class, args);
		System.out.println("Running application Microservices Banking Loans Service Project !");
	}

}
