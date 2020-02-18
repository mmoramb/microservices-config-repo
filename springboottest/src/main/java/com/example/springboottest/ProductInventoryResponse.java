package com.example.springboottest;

import lombok.Data;

@Data
public class ProductInventoryResponse {
	private String productCode;
	private int availableQuatity;
	
	
	
	public ProductInventoryResponse() {
		
	}
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public int getAvailableQuatity() {
		return availableQuatity;
	}
	public void setAvailableQuatity(int availableQuatity) {
		this.availableQuatity = availableQuatity;
	}
	
	
}
