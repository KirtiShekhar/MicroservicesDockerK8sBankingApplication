package com.microservices.banking.loans.service.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservices.banking.loans.service.project.entity.Loans;

@Repository
public interface LoansRepository extends JpaRepository<Loans, Long> 
{
	@Query(value = "select l from Loans l where l.customerId=:customerId")
	List<Loans> findByCustomerId(@Param("customerId") Long customerId);
	
	List<Loans> findByLoanType(String loanType);
}
