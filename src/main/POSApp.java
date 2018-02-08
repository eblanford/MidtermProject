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
		String purchase = "n";
		int option;
		ArrayList<Product> basket = new ArrayList<Product>();

		// System greeting
		System.out.println("Welcome to the Grand Circus Tea Party!");
		System.out.println("What is your name? ");
		userName = scan.nextLine();

		// Stores userItem with the product information and quantity
		userItem = itemMenu(scan);

		// Will allow user to exit store once inside the if statement
		OUTER_LOOP:
		// checks that user did not choose to exit the store
		while (userItem != null) {
			// Verifies if the user would like to purchase, select a new item, or exit
			while (purchase.equalsIgnoreCase("n")) {
				option = Validator.getInt(scan,
						"\nYour options are: \n1.Purchase these items\n2.Return to Menu Without Purchasing\n3.Exit Store\nSelection: ",
						1, 3);
				switch (option) {
				case 1:
					basket = ShoppingCart.addToCart(userItem, basket);
					String viewCart = Validator.getString(scan, "Would you like to view your cart total? (yes/no) ",
							"yes", "no");
					if (viewCart.equalsIgnoreCase("yes"))
						ShoppingCart.viewShoppingCart(basket);
					String keepShopping = Validator.getString(scan, "\nWould you like to continue shopping? (yes/no) ",
							"yes", "no");
					if (keepShopping.equalsIgnoreCase("yes")) {
						userItem = itemMenu(scan);
					} else {
						purchase = "y";
					}
					break;
				case 2:
					userItem = itemMenu(scan);
					break;
				case 3:
					userItem = null;
					break OUTER_LOOP;
				}
			}

			paymentType = Validator.getString(scan, "\nWill you be paying with a check, cash, or credit today? ",
					"cash",
					"check", "credit");
			userPayment = createPayment(paymentType, basket);
			userPayment.receipt(basket, scan);
			basket.clear();

			String newOrder = Validator.getString(scan, "\nWould you like to start a new order? (yes/no) ", "yes",
					"no");
			if (newOrder.equalsIgnoreCase("no")) {
				userItem = null;
			} else {
				purchase = "n";
				userItem = itemMenu(scan);
			}
		}

		System.out.println("\nThanks for shopping with us today, " + userName);
		scan.close();
	}

	// Run's through the menu and get's the user's choice
	public static Product itemMenu(Scanner sc) {
		System.out.println();
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
		userOption = Validator.getInt(sc, "\nPlease pick an item number from the list to view: ", 1, count);

		if (userOption != count) {
			// Creates our new product
			userItem = fileInput.get(userOption - 1);

			System.out.print("\nThe item you selected is a " + userItem.getName());
			System.out.printf(", the cost of this item is $%.2f\n", userItem.getPrice() / (double) (100));
			
			userItem.setQuantity(Validator.getInt(sc,
					"\nPlease enter the quantity you would like to purchase. Qty: ",
					0));

			System.out.printf(userItem.getQuantity() + " " + userItem.getName() + "(s) will cost: $%.2f\n",
					(userItem.getPrice() * userItem.getQuantity()) / ((double) 100));
		}

		return userItem;
	}

	// determines which subclass to set our Pay object to
	public static Payment createPayment(String paymentType, ArrayList<Product> cart) {
		if (paymentType.equalsIgnoreCase("cash")) {
			return new Cash(ShoppingCart.sumCart(cart));
		} else if (paymentType.equalsIgnoreCase("credit")) {
			return new CreditCard(ShoppingCart.sumCart(cart));
		} else {
			return new Check();
		}
	}
}
