package com.myapp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableSwagger2WebMvc
@EnableFeignClients
public class ApplicationCatalogMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationCatalogMicroserviceApplication.class, args);
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
