package main;

import java.util.ArrayList;
import java.util.Scanner;

import pay.Cash;
import pay.Check;
import pay.CreditCard;
import pay.Payment;
import products.Product;
import utilities.ReadWriteFiles;
import utilities.Validator;

public class POSApp {

	public static void main(String[] args) {
		// Variable Declaration
		Scanner scan = new Scanner(System.in);
		Product userItem;
		Payment userPayment;
		String paymentType;
		String userName;
		String purchase = "y";
		int option;
		// ArrayList<Product> basket = new ArrayList<Product>();

		// System greeting
		System.out.print("Welcome to the Grand Circus Tea Party!");
		userName = Validator.getString(scan, "What is your name? ");
		//FIXME: Take in a line, not just a single word??
		
		// Stores userItem with the product information and quantity
		userItem = itemMenu(scan);
		
		// Will allow user to exit store once inside the if statement
		OUTER_LOOP:
		//checks that user did not choose to exit the store
		if (userItem != null) {
			// Verifies if the user would like to purchase, select a new item, or exit
			while (purchase.equalsIgnoreCase("n")) {
				option = Validator.getInt(scan,
						"Your options are: \n1. Purchase these items\2.Return to Menu\3.Exit Store", 1, 3);
				switch (option) {
				case 1:
					purchase = "y";
					printReceipt(userItem);
					break;
				case 2:
					userItem = itemMenu(scan);
					break;
				case 3:
					userItem = null;
					break OUTER_LOOP;
				}
			}


			// FIXME add an overloaded method to the getString to only accept three given
			// inputs
			paymentType = Validator.getString(scan, "Will you be paying with a check, cash, or credit today?", "cash",
					"check", "credit");
			userPayment = createPayment(paymentType);

			// FIXME add method in Pay Classes that collect payment information
			userPayment.payment();
			// FIXME add method in Pay Classes that print receipt and store order to .txt
			// file
			userPayment.receipt();


		}
		
		System.out.println("Thanks for shopping with us today, " + userName);
		scan.close();
	}

	// Run's through the menu and get's the user's choice
	public static Product itemMenu(Scanner sc) {
		ArrayList<Product> fileInput = new ArrayList<Product>();
		fileInput = ReadWriteFiles.readFromFile();
		int userOption;
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
			// userItem.setQty() = Validator.getInt(sc,
			// "Please enter the quantity you would like to purchase (we do not have the
			// capacity to make more than 100)\nQty:",
			// 0, 100);
		
			// FIXME Need a subTotal method in Product class (qty * price)
			// System.out.println("Your subtotal comes to: " + userItem.subTotal() /
			// ((double) 100));
		}
		
		
		return userItem;
	}


	// FIXME to include subTotal, taxTotal, and grandTotal calculation methods in
	// Product
	// Prints subtotals, tax, and total
	public static void printReceipt(Product item) {
		System.out.printf("%-10s $%-10.2f", "Subtotal:", item.subTotal() / ((double) 100));
		System.out.printf("%-10s $%-10.2f", "Tax:", item.taxTotal() / ((double) 100));
		System.out.printf("%-10s $%-10.2f", "Grand Total:", item.grandTotal() / ((double) 100));
	}

	// determines which subclass to set our Pay object to
	public static Payment createPayment(String paymentType) {
		if (paymentType.equalsIgnoreCase("cash")) {
			return new Cash();
		} else if (paymentType.equalsIgnoreCase("credit")) {
			return new CreditCard();
		} else {
			return new Check();
		}
	}
}
