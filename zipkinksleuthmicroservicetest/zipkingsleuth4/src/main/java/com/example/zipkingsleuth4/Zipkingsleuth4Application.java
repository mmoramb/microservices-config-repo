package com.example.zipkingsleuth4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Zipkingsleuth4Application {

	public static void main(String[] args) {
		SpringApplication.run(Zipkingsleuth4Application.class, args);
	}
}

@RestController
class ZipkinController{
     
    @Autowired
    RestTemplate restTemplate;
 
    @Bean
    public RestTemplate getRestTemplate1() {
        return new RestTemplate();
    }
 
    @Bean
    public AlwaysSampler alwaysSampler1() {
        return new AlwaysSampler();
    }
 
    @GetMapping(value="/zipkin4")
    public String zipkinService1() 
    {
        System.out.println("Inside zipkinService 1..");
         
//         String response = (String) restTemplate.exchange("http://localhost:8084/zipkin3", 
//                        HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();
        return "Hi...";
    }
}
