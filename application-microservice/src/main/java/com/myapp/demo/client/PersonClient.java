package com.myapp.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("USER-MS")
public interface PersonClient {
	
	@GetMapping("persons/{id}")
	EntityModel<Person> getById(@PathVariable("id") Integer id);
	
	@PostMapping("persons")
	EntityModel<Person> saveNewPerson(@RequestBody Person person);

}
