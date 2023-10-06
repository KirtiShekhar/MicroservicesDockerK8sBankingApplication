package com.microservices.banking.cards.service.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservices.banking.cards.service.project.entity.Cards;

@Repository
public interface CardsRepository extends JpaRepository<Cards, Long> 
{
	@Query(value = "select c from Cards c where c.customerId=:customerId")
	List<Cards> findByCustomerId(@Param("customerId") Long customerId);
	
	List<Cards> findByCardType(String cardType);
	
	Optional<Cards> findByCardNumber(String cardNumber);
}
