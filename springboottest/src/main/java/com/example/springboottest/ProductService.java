package com.example.springboottest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
 
@Service
@Transactional
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    private final RestTemplate restTemplate;
    
    @Autowired
    public ProductService(ProductRepository productRepository, RestTemplate restTemplate) {
        this.productRepository = productRepository;
        this.restTemplate = restTemplate;
    }
 
    
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
 
    public Optional<Product> findProductByCode(String code) {
    	Optional<Product> productOptional = productRepository.findByCode(code);
    	if (productOptional.isPresent()) {
			ResponseEntity<ProductInventoryResponse> itemEntityRes = restTemplate.getForEntity(
					"http://inventory-service/api/inventory/{code}", ProductInventoryResponse.class,
					code);
			
			if (itemEntityRes.getStatusCode() == HttpStatus.OK) {
				Integer quantity = itemEntityRes.getBody().getAvailableQuantity();
                productOptional.get().setInStock(quantity > 0);
			} else {
				System.out.println("Unable to get inventory level for product_code");
			}
		}
    	
    	return productOptional;
    }
    
    
}