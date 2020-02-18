package com.example.springzuulmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
@EnableZuulProxy
@SpringBootApplication
public class SpringzuulmicroserviceApplication {
	
	@Bean
	AuthHeaderFilter authHeaderFilter() {
	    return new AuthHeaderFilter();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringzuulmicroserviceApplication.class, args);
	}

}
