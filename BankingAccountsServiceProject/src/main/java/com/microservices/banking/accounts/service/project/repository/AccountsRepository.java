package com.microservices.banking.accounts.service.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservices.banking.accounts.service.project.entity.Accounts;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> 
{
	@Query(value = "select a from Accounts a where a.customerId=:customerId")
	List<Accounts> findByCustomerId(@Param("customerId") Long customerId);
	Accounts findByAccountNumber(Long accountNumber);
}
