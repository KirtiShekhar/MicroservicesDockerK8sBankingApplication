package com.microservices.banking.cloud.gateway.api.project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class Oauth2SecurityConfiguration 
{
	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http)throws Exception
	{
		return http
		        .csrf(csrf -> csrf.disable())
		        .authorizeExchange(auth -> auth
		            .pathMatchers("/api/accounts/**").authenticated()
		            .pathMatchers("/api/cards/**").authenticated()
		            .pathMatchers("/api/loans/**").authenticated())
		        .oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()))
		        .build();
	}
}
