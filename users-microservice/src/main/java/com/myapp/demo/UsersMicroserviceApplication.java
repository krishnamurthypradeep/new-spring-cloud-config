package com.myapp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.myapp.demo.domain.Person;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableSwagger2WebMvc
public class UsersMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersMicroserviceApplication.class, args);
	}
	
	
	//https://pastebin.com/qkYX36sT
	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer()
	{
	    return RepositoryRestConfigurer.withConfig(config -> {
	        config.exposeIdsFor(Person.class);
	    });
	}
//	
//	@Bean
//	public TypeResolver typeResolver() {
//		return new TypeResolver();
//	}
//	
//	@Bean
//	@Autowired
//	public HandlerMethodResolver handlerMethodResolver(TypeResolver typeResolver) {
//		return new HandlerMethodResolver(typeResolver);
//	}

}
