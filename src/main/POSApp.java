package main;

import java.util.ArrayList;
import java.util.Scanner;

import pay.Pay;
import products.Product;
import utilities.ReadWriteFiles;
import utilities.Validator;

public class POSApp {

	public static void main(String[] args) {
		// Variable Declaration
		Scanner scan = new Scanner(System.in);
		Product userItem;
		Pay userPayment;
		String userName;

		// System greeting
		System.out.print("Welcome to the Grand Circus Tea Party!");
		userName = Validator.getString(scan, "What is your name? ");


	}

	public static Product itemMenu(Scanner sc) {
		ArrayList<Product> fileInput = new ArrayList<Product>();
		fileInput = ReadWriteFiles.readFromFile();
		int userOption;
		int userQuantity;
		Product userItem = null;
		int count = 1;

		// prints out menu with just tea names and number
		for (int i = 0; i < fileInput.size(); i++) {
			System.out.println("Item " + count + ": " + fileInput.get(i).getName());
			count++;
		}
		// exit option
		System.out.println(count + ": Exit Store");

		// Prompts the user to pick an item
		userOption = Validator.getInt(sc, "Please pick an item number from the list to view: ", 1, count);

		if(userOption != count) {
			//Creates our new product
			userItem = fileInput.get(userOption -1);

			// FIXME OR SYSOUT userItem via "toString" formatting
			System.out.print("The item you selected is " + userItem.getName());
			System.out.println(", the cost of this item is $" + userItem.getPrice() / (double) (100));
			
			// FIXME Need a Qty variable, getters & setters in Product Class Folder
			userItem.setQty() = Validator.getInt(sc,
					"Please enter the quantity you would like to purchase (we do not have the capacity to make more than 100)\nQty:",
					0, 100);
		
			// FIXME Need a subTotal method in Product class (qty * price)
			System.out.println("Your subtotal comes to: " + userItem.subTotal() / ((double) 100));
		}
		
		
		return userItem;
	}


}
