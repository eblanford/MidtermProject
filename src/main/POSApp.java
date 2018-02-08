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
		Product userItem = new Product();
		Payment userPayment;
		String paymentType;
		String userName;
		String purchase = "y";
		int option;
		ArrayList<Product> basket = new ArrayList<Product>();

		// System greeting
		System.out.print("Welcome to the Grand Circus Tea Party!");
		System.out.println("What is your name? ");
		userName = scan.nextLine();

		// Stores userItem with the product information and quantity
		userItem = itemMenu(scan);

		// Will allow user to exit store once inside the if statement
		OUTER_LOOP:
		// checks that user did not choose to exit the store
		if (userItem != null) {
			// Verifies if the user would like to purchase, select a new item, or exit
			while (purchase.equalsIgnoreCase("n")) {
				option = Validator.getInt(scan,
						"Your options are: \n1. Purchase these items\2.Return to Menu\3.Exit Store", 1, 3);
				switch (option) {
				case 1:
					purchase = "y";
					basket = ShoppingCart.addToCart(userItem, basket);
					String viewCart = Validator.getString(scan, "Would you like to view your cart total? (yes/no)",
							"yes", "no");
					if (viewCart.equalsIgnoreCase("yes"))
						ShoppingCart.viewShoppingCart(basket);
					break;
				case 2:
					userItem = itemMenu(scan);
					break;
				case 3:
					userItem = null;
					break OUTER_LOOP;
				}
			}

			paymentType = Validator.getString(scan, "Will you be paying with a check, cash, or credit today?", "cash",
					"check", "credit");
			userPayment = createPayment(paymentType);

			// FIXME add method in Pay Classes that collect payment information
			userPayment.pay();
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

		if (userOption != count) {
			// Creates our new product
			userItem = fileInput.get(userOption - 1);

			System.out.print("The item you selected is " + userItem.getName());
			System.out.printf(", the cost of this item is $%.2f", userItem.getPrice() / (double) (100));
			
			userItem.setQuantity(Validator.getInt(sc,
					"Please enter the quantity you would like to purchase\nQty:",
					0));

			// FIXME maybe make a subTotal method in Product class (qty * price)
			System.out.printf("Your subtotal comes to: $%.2f",
					(userItem.getPrice() * userItem.getQuantity()) / ((double) 100));
		}

		return userItem;
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
