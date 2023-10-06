package com.microservices.banking.accounts.service.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.banking.accounts.service.project.entity.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> 
{
	Customers findByCustomerEmailAddress(String customerEmailAddress);
}
