package com.example.springzuulmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
@EnableZuulProxy
@SpringBootApplication
public class SpringzuulmicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringzuulmicroserviceApplication.class, args);
	}

}
