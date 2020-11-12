package com.myapp.demo.api;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyAPI {
	
	@GetMapping("/")
	public String getData() {
		return LocalDate.now().toString();
	}


}
