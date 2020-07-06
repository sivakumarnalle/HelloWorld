package com.javainuse.model;

import java.util.HashMap;
import java.util.Map;

public class Product {

	private Map<String, String> atrbMap = new HashMap<>();
	private String type;
	private String name;
	private String price;
	private int discount;
	
	
	public Map<String, String> getAtrbMap() {
		return atrbMap;
	}

	public void setAtrbMap(Map<String, String> atrbMap) {
		this.atrbMap = atrbMap;
	}

	public String fetchAttribute(String type) {
		return atrbMap.get(type);
	}
	
	public void setAttribute(String type, String value) {
		this.atrbMap.put(type, value);
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

}