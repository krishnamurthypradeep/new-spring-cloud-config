package com.myapp.demo.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.myapp.demo.domain.Application;
import com.myapp.demo.repository.ApplicationRepository;

@Component
public class ApplicationManagementDataLoader implements 
ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private ApplicationRepository repository;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		
		List<Application> list = Arrays.asList
		(new Application("AppTracker","Fixing Bugs",1),
	new Application("Order management","Fixing Bugs",2),
	new Application("Expense Reporting","Fixing Bugs",1),
	new Application("Time Tracker","Fixing Bugs",2),
	new Application("Schedule Management","Fixing Bugs",1));
		repository.saveAll(list);
	}

}
