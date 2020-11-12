package com.myapp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.demo.client.Person;
import com.myapp.demo.client.PersonClient;
import com.myapp.demo.domain.Application;
import com.myapp.demo.repository.ApplicationRepository;

@BasePathAwareController
public class ApplicationCatalogController {
	
	@Autowired
	private ApplicationRepository repository;
	
	@Autowired
	private PersonClient personClient;
	
	@GetMapping(path = "applications",
			produces ="application/hal+json" )
	@ResponseBody
	public ResponseEntity<?> getApplications(){
		
		List<Application> list=repository.findAll();
		list.forEach(app->getPersonInfoUsingFeign(app));
		
		CollectionModel<Application> resources=
				new CollectionModel<>(list);
		
		resources.add(WebMvcLinkBuilder.linkTo(
				WebMvcLinkBuilder.methodOn
				(ApplicationCatalogController.class)
				.getApplications()).withSelfRel());
		
		return ResponseEntity.ok(resources);
	}

	
	@PostMapping(path = "applications",
			produces ="application/hal+json" )
	@ResponseBody
	public ResponseEntity<?> save(
			@RequestBody Application application){
		
		
//		List<Application> list=repository.findAll();
//		list.forEach(app->getPersonInfoUsingFeign(app));
		Person person = 
				new Person(application.getOwnerRole());
		
		person=personClient.saveNewPerson(person).getContent();
		System.out.println("person id ****"+person.getId());
		application.setOwnerId(person.getId());
	
		
		repository.save(application);
		
		EntityModel<Application> resources=
				new EntityModel<>(application);
		
		resources.add(WebMvcLinkBuilder.linkTo(
				WebMvcLinkBuilder.methodOn
				(ApplicationCatalogController.class)
				.getApplications()).withSelfRel());
		
		return ResponseEntity.ok(resources);
	}
	private void getPersonInfoUsingFeign(Application app)  {
		Person person=personClient.getById(app.getOwnerId()).getContent();
		app.setOwnerRole(person.getRole());
	}
	
	private void getPersonInfo(Application app)  {
		// TODO Auto-generated method stub
		RestTemplate template = new RestTemplate();
		
		String userService=
		"http://localhost:8812/persons/"+app.getOwnerId();
		ResponseEntity<String> response=
		template.getForEntity(userService, String.class);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode root=null;
		try {
			root = mapper.readTree(response.getBody());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonNode role = root.path("role");
		app.setOwnerRole(role.asText());
		
	}
	

}
