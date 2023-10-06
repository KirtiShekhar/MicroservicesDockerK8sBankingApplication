package com.microservices.banking.accounts.service.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableFeignClients("com.microservices.banking.accounts.service.project.feignClient")
@OpenAPIDefinition(info = @Info(title = "microservices-banking-accounts-service-project", version = "2.0", description = "Spring Boot Application Microservices accounts services project for banking application"))
public class MicroservicesBankingAccountsServiceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesBankingAccountsServiceProjectApplication.class, args);
		System.out.println("Running application Microservices Banking Accounts Service Project !");
	}

}
