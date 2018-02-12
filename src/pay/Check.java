/*
 * Subclass of Payment
 * Used for check payments to:
 * 1. Prompt the user for check number
 * 2. Returns a receipt & check number
 */

package pay;

import java.util.ArrayList;
import java.util.Scanner;

import main.ShoppingCart;
import products.Product;
import utilities.ReadWriteFiles;
import utilities.Validator;

public class Check extends Payment {
	private long checkNumber;

	// Constructors
	public Check() {
		super();
	}

	public Check(int subTotal) {
		super(subTotal);
	}

	public long getCheckNumber() {
		return checkNumber;
	}

	// Setter prompts for user check number using Validator
	public void setCheckNumber(Scanner sc) {
		this.checkNumber = Validator.getLong(sc, "\nWhat is your check number? ", 0l);
	}

	@Override
	public void receipt(ArrayList<Product> cart, Scanner sc, String name) {
		setCheckNumber(sc);

		// Item list
		System.out.printf("\n%-5s %-30s %-10s\n", "Qty:", "Item", "Amt.");
		System.out.println("--------------------------------------------");
		for (int i = 0; i < cart.size(); i++) {
			System.out.printf("%-5d %-30s $%-10.2f\n", cart.get(i).getQuantity(), cart.get(i).getName(),
					(cart.get(i).getPrice() / ((double) 100)));
		}

		// Cost Information
		ShoppingCart.viewShoppingCart(cart);

		// Payment information
		System.out.printf("\n%-15s %-10s\n", "Payment Type:", "Check");
		System.out.printf("%-15s %-10d\n", "Check #:", checkNumber);

		// Saves order to file for later use
		ReadWriteFiles.writeToFile(cart, super.getSubTotal(), super.getTaxTotal(), super.getGrandTotal(), name);

	}


}