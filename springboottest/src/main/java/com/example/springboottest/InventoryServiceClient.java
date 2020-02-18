package com.example.springboottest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InventoryServiceClient {
	private final RestTemplate restTemplate;
	
	@Autowired
	public InventoryServiceClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@HystrixCommand(fallbackMethod = "getDefaultProductInventoryByCode",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"),
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000"),
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
			})
	public Optional<ProductInventoryResponse> getProductInventoryByCode(String productCode){
		ResponseEntity<ProductInventoryResponse> itemResponseEntity = restTemplate.getForEntity(
				"http://inventory-service/api/inventory/{code}", ProductInventoryResponse.class,
				productCode);
		
		if (itemResponseEntity.getStatusCode() == HttpStatus.OK) {
			return Optional.ofNullable(itemResponseEntity.getBody());
		} else {
			return Optional.empty();
		}
	}
	
	Optional<ProductInventoryResponse> getDefaultProductInventoryByCode(String productCode){
		ProductInventoryResponse response = new ProductInventoryResponse();
		response.setProductCode(productCode);
		response.setAvailableQuatity(50);
		
		return Optional.ofNullable(response);
	}
}
