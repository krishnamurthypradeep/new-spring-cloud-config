package com.myapp.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.myapp.demo.domain.Ticket;


// https://pastebin.com/Wg79K86y

// http://localhost:8080/tickets
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {


	@RestResource(path="titleIgnoreCaseContaining",rel = "titleIgnoreCaseContaining")
List<Ticket> findByDescriptionIgnoreCaseContaining(String description);	

List<Ticket> findByDescriptionIgnoreCaseStartingWith(String stateName);
Ticket findFirstByDescriptionIgnoreCaseStartingWith(String stateName);
//List<Ticket> findByDescriptionNotLikeOrderByStateAsc(String stateName);

//List<Ticket> findByDescriptionIsOrCountryEquals(String value, String value2);
List<Ticket> findByDescriptionNot(String state);



}
