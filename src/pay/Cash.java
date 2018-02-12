/*
 * Subclass of Payment
 * Used for cash payments to:
 * 1. Prompt the user for cash tendered
 * 2. Return a receipt & change
 */

package pay;

import java.util.ArrayList;
import java.util.Scanner;

import main.ShoppingCart;
import products.Product;
import utilities.ReadWriteFiles;
import utilities.Validator;

public class Cash extends Payment {
	private double inputCash;

	// Constructors
	public Cash() {
		super();
		inputCash = 0;
	}

	public Cash(int subTotal) {
		super(subTotal);
	}

	public double getInputCash() {
		return inputCash;
	}

	// Uses the setter method to prompt user for cash input and returns change due
	public double setInputCash(Scanner sc) {
		this.inputCash = Validator.getDouble(sc, "\nPlease enter the amount of cash you will be paying with: ",
				(super.getGrandTotal() / 100));
		double change = inputCash - (super.getGrandTotal() / ((double) 100));
		System.out.printf("Here is your change: $%.2f\n\n", change);
		return change;
	}

	@Override
	public void receipt(ArrayList<Product> cart, Scanner sc, String name) {
		double change = setInputCash(sc);
		
		// Item list
		System.out.println("test");
		System.out.printf("\n%-5s %-30s %-10s\n", "Qty:", "Item", "Amt.");
		System.out.println("--------------------------------------------");
		for (int i = 0; i < cart.size(); i++) {
			System.out.printf("%-5d %-30s $%-10.2f\n", cart.get(i).getQuantity(), cart.get(i).getName(),
					(cart.get(i).getPrice() / ((double) 100)));
		}

		// Cost information
		ShoppingCart.viewShoppingCart(cart);

		// Payment information
		System.out.printf("\n%-15s %-10s\n", "Payment Type:", "Cash");
		System.out.printf("%-15s $%-10.2f\n", "Tendered:", inputCash);
		System.out.printf("%-15s $%-10.2f\n", "Change due:", change);

		// Saves order to file for later use
		ReadWriteFiles.writeToFile(cart, super.getSubTotal(), super.getTaxTotal(), super.getGrandTotal(), name);
	}

	@Override
	public String toString() {
		return super.getSubTotal() + "," + super.getTaxTotal() + "," + super.getGrandTotal() + "," + inputCash;
	}

}