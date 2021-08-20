package com.app.model;

public class SuccOrder {
	private String name;
	private double price;
	@Override
	public String toString() {
		return "SuccOrder [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
	private int quantity;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
