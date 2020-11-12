package com.myapp.demo.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.myapp.demo.domain.Person;
import com.myapp.demo.repository.PersonRepository;

@Component
public class UserManagementDataLoader implements 
ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private PersonRepository repository;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		
		List<Person> list = Arrays.asList
				(new Person("Business Owner"),
				new Person("Scrum Master"),
				new Person("Developer"),
				new Person("Tester"),
				new Person("QA Tester"),
				new Person("Business Analyst"));
		repository.saveAll(list);
	}

}
