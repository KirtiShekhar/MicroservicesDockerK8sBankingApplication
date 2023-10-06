package com.microservices.banking.configuration.server.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicroservicesBankingConfigurationServerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesBankingConfigurationServerProjectApplication.class, args);
		System.out.println("Running application Microservices Banking Configuration Server Project !");
	}

}
