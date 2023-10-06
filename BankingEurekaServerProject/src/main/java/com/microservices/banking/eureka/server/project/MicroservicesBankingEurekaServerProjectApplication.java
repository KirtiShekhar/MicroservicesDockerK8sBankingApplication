package com.microservices.banking.eureka.server.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroservicesBankingEurekaServerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesBankingEurekaServerProjectApplication.class, args);
		System.out.println("Running application Microservices Banking Eureka Server Project !");
	}

}
