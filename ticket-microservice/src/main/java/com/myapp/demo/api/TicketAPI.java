package com.myapp.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.demo.domain.Ticket;
import com.myapp.demo.repository.TicketRepository;

//@RestController
public class TicketAPI {

	@Autowired	
	private TicketRepository repository;
	
	
	@GetMapping("/tickets")
	public List<Ticket> getAll(){
		return repository.findAll();
		
	}
	
	@GetMapping("/tickets/{id}")
	public Ticket getTicketById(@PathVariable("id")Integer id){
		return repository.findById(id).get();
		
	}
	
	@PostMapping("/tickets")
	public Ticket addNewTicket(@RequestBody Ticket ticket) {
		return repository.save(ticket);
	}
	
	@DeleteMapping("/tickets/{id}")
	public ResponseEntity<String> deleteTicket(@PathVariable("id")Integer id){
		repository.deleteById(id);
		return new ResponseEntity<String>("Ticket Removed",
				HttpStatus.OK);
		
	}

	
}
