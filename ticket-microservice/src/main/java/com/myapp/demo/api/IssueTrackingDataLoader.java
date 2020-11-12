package com.myapp.demo.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.myapp.demo.domain.Ticket;
import com.myapp.demo.repository.TicketRepository;

@Component
public class IssueTrackingDataLoader implements 
ApplicationListener<ContextRefreshedEvent> {

	
	@Autowired
	private TicketRepository repository;
	
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
	
		List<Ticket> list=
		Arrays.asList(
		 new Ticket("Add the ability to sort by release date", "The users need this new feature", 1, 2),
         new Ticket("Updates are not saved correctly to task name", "This is a bug impacting this feature in production", 1, 2),
        new Ticket("Provide a list of applications for users", "The users need this new feature", 2, 1),
        new Ticket("Provide a list of tickets for an application", "The users need this new feature", 2, 1),
        new Ticket("Provide a list of tickets for a given release", "The users need this new feature", 3, 4),
        new Ticket("Give user the ability to add tickets to a release", "The users need this new feature", 4, 5),
         new Ticket("Add the ability to sort by release date", "The users need this new feature", 1, 2),
         new Ticket("Updates are not saved correctly to task name", "This is a bug impacting this feature in production", 1, 2),
         new Ticket("Provide a list of applications for users", "The users need this new feature", 2, 1),
         new Ticket("Provide a list of tickets for an application", "The users need this new feature", 2, 1),
         new Ticket("Provide a list of tickets for a given release", "The users need this new feature", 3, 4),
        new Ticket("Give user the ability to add tickets to a release", "The users need this new feature", 4, 5),
 new Ticket("Add the ability to sort by release date", "The users need this new feature", 1, 2),
 new Ticket("Updates are not saved correctly to task name", "This is a bug impacting this feature in production", 1, 2),
      new Ticket("Provide a list of applications for users", "The users need this new feature", 2, 1),
  new Ticket("Provide a list of tickets for an application", "The users need this new feature", 2, 1),
  new Ticket("Provide a list of tickets for a given release", "The users need this new feature", 3, 4),
   new Ticket("Give user the ability to add tickets to a release", "The users need this new feature", 4, 5),
     new Ticket("Add the ability to sort by release date", "The users need this new feature", 1, 2),
 new Ticket("Updates are not saved correctly to task name", "This is a bug impacting this feature in production", 1, 2),
    new Ticket("Provide a list of applications for users", "The users need this new feature", 2, 1),
       new Ticket("Provide a list of tickets for an application", "The users need this new feature", 2, 1),
new Ticket("Provide a list of tickets for a given release", "The users need this new feature", 3, 4),
         new Ticket("Give user the ability to add tickets to a release", "The users need this new feature", 4, 5),
        new Ticket("Add the ability to sort by release date", "The users need this new feature", 1, 2),
     new Ticket("Updates are not saved correctly to task name", "This is a bug impacting this feature in production", 1, 2),
   new Ticket("Provide a list of applications for users", "The users need this new feature", 2, 1),
 new Ticket("Provide a list of tickets for an application", "The users need this new feature", 2, 1),
    new Ticket("Provide a list of tickets for a given release", "The users need this new feature", 3, 4),
       new Ticket("Give user the ability to add tickets to a release", "The users need this new feature", 4, 5));

	repository.saveAll(list);
	
	
	//select ticket0_.ticket_id as ticket_i1_0_, ticket0_.application_id as applicat2_0_, ticket0_.description as descript3_0_, ticket0_.person_id as person_i4_0_, ticket0_.title as title5_0_ from ticket ticket0_ where upper(ticket0_.description) like upper(?) escape ?
	repository.findByDescriptionIgnoreCaseContaining("users")
	.forEach(System.out::println);
		
	}

	//pastebin.com/6zmjfV3z
	
	
}


