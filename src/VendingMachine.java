import java.io.*;
import java.util.Scanner;

/*************************************************************************
 * Simulates a real life vending machine with stock read from a file.
 * 
 * CSCE 155A Spring 2018
 * Assignment 4
 * @file VendingMachine.java
 * @author Vu Thai
 * @version 1.0
 * @date March 26, 2018
 *************************************************************************/

public class VendingMachine {
	
	//data members
	private Item[] stock;  //Array of Item objects in machine
	private double money;  //Amount of revenue earned by machine
	
	public Item[] getStock() {
		return stock;
	}
	public void setStock(Item[] stock) {
		this.stock = stock;
	}
	// Generate getters and setters for money
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	/*********************************************************************
	 * This is the constructor of the VendingMachine class that take a
	 * file name for the items to be loaded into the vending machine.
	 *
	 * It creates objects of the Item class from the information in the 
	 * file to populate into the stock of the vending machine.  It does
	 * this by looping the file to determine the number of items and then
	 * reading the items and populating the array of stock. 
	 * 
	 * @param filename Name of the file containing the items to stock into
	 * this instance of the vending machine. 
	 * @throws FileNotFoundException If issues reading the file.
	 *********************************************************************/
	public VendingMachine(String filename) throws FileNotFoundException {
		//Open the file to read with the scanner
		File file = new File(filename);
		Scanner scan = new Scanner(file);

		//Determine the total number of items listed in the file
		int totalItem = 0;
		while (scan.hasNextLine()) {
			scan.nextLine();
			totalItem++;
		} //End while another item in file
		//Create the array of stock with the appropriate number of items
		stock = new Item[totalItem];
		scan.close();

		//Open the file again with a new scanner to read the items
		scan = new Scanner(file);
		int itemQuantity = -1;
		double itemPrice = -1;
		String itemDesc = "";
		int count = 0;
		String line = "";

		//Read through the items in the file to get their information
		//Create the item objects and put them into the array of stock
		while(scan.hasNextLine()) {
			line = scan.nextLine();
			String[] tokens = line.split(",");
			try {
				itemDesc = tokens[0];
				itemPrice = Double.parseDouble(tokens[1]);
				itemQuantity = Integer.parseInt(tokens[2]);
				
				stock[count] = new Item(itemDesc, itemPrice, itemQuantity);
				count++;
			} catch (NumberFormatException nfe) {
				System.out.println(itemDesc+ " " + itemPrice+ " " +  itemQuantity);
				System.out.println("Bad item in file " + filename + 
						" on row " + (count+1) + ".");
			}
		} //End while another item in file
		scan.close();
		
		//Initialize the money data variable.
		money = 0.0;
	} //End VendingMachine constructor
	/**
	 * Method that stimulate the vending transaction
	 * after a valid amount of money has been entered
	 * @param userInput
	 */
	public void vend(int userInput) {
		int  i = 0;
		for (Item item : this.stock) {
			i++;
			if (i == userInput) {
				item.setQuantity(item.getQuantity() - 1);
				this.money += item.getPrice();
			}
		}
	}
	/**
	 * Method that display an appropriate message that tells the
	 * customer if their transaction is succeed. It will return -1 if user dont
	 * have enough money, 0 for out of stock and 1 for success transaction
	 * @param userInput
	 * @param moneyInput
	 * @return holds
	 */
	public int outputMessage(int userInput, double moneyInput) {
		int i = 0;
		int holds = -1;
		for (Item item : this.stock) {
			i++;
			if (i == userInput) {
				if(item.getQuantity() < 0) {
					holds = 0;
					System.out.println("Sorry, we are out of this item");
					item.setQuantity(item.getQuantity() + 1);
					moneyInput += item.getPrice();
					this.money -= item.getPrice(); // Refund the money from the machine to user
					break;
				} else if(moneyInput - item.getPrice() < 0) {
					System.out.println("You do not have enough money, please add more money of press exit.");
					item.setQuantity(item.getQuantity() + 1);
					moneyInput += item.getPrice();
					this.money -= item.getPrice(); // Refund the money from the machine to user
					holds = -1;
					break;
				} else {
					holds = 1;
					System.out.println(String.format("You have bought %s for $%.2f. You change is $%.2f",
					item.getDescription(), item.getPrice(), moneyInput - item.getPrice() ));
					break;
				}
			}
		}
		return holds;
	}
	/**
	 * Method that print out the Menu based on the User choice or Snacks or drinks
	 *
	 */
	public void printMenu() {
		int i = 0;
		System.out.println("Menu: ");
		System.out.println("     Item#\t  Item\t\t\t Price\t Qty");
		for (Item item : this.stock) {
			i++;
			System.out.println(String.format("\t%d\t %-23s %-10.2f %-10d", i, item.getDescription(), 
					item.getPrice(), item.getQuantity()));
		}
		
	}
} //End VendingMachine class definition
