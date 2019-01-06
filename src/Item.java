
/**
 * This class create an instance of an item in a vending machine
 * CSCE 155A Spring 2018
 * Assignment 6
 * @file Item.java
 * @author Vu Thai
 * @version 2.0
 * @date April 20, 2018
 */
public class Item {
	@Override
	public String toString() {
		return String.format("%s-$%.2f(%d)\n", this.getDescription(), this.getPrice(), this.getQuantity());
	}

	protected String description;
	protected double price;
	protected int quantity;
	// Generate getter and setters
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	// Create a constructor based on fields
	public Item(String description, double price, int quantity) {
		super();
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
}
