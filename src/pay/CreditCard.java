/*
 * Subclass of Payment
 * Used for credit card payments to:
 * 1. Prompt the user for credit card number
 * Future Improvement: Add a validation for correct number of digits (16)
 * 2. Prompt the user for CVV number 
 * Future Improvement: Add a validation that it is between 3-4 digits
 * 3. Prompt the user for exp Date
 * Future Improvement: Add a validation that requires mm/yy entry
 * 4. Return a receipt & change
 */

package pay;

import java.util.ArrayList;
import java.util.Scanner;

import main.ShoppingCart;
import products.Product;
import utilities.ReadWriteFiles;

public class CreditCard extends Payment {
	private String exp;
	private long ccNum;
	private String cvv;

	// Constructor
	public CreditCard(int subTotal) {
		super(subTotal);
	}

	// Generic getters and setters
	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public long getCcNum() {
		return ccNum;
	}

	public void setCcNum(long ccNum) {
		this.ccNum = ccNum;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	@Override
	public void receipt(ArrayList<Product> cart, Scanner sc, String name) {

		// Collect information from user
		System.out.println("CreditCard Number: ");
		setCcNum(sc.nextLong());
		sc.nextLine();
		System.out.println("CVV: ");
		setCvv(sc.nextLine());
		System.out.println("Exp date(mm/yy): ");
		setExp(sc.nextLine());

		// Gets last four digits of credit card
		String lastFour = Long.toString(getCcNum());
		lastFour = lastFour.substring(lastFour.length() - 4);
		

		// Item list
		System.out.printf("\n%-5s %-30s %-10s\n", "Qty:", "Item", "Amt.");
		System.out.println("-------------------------------------------");
		for (int i = 0; i < cart.size(); i++) {
			System.out.printf("%-5d %-30s $%-10.2f\n", cart.get(i).getQuantity(), cart.get(i).getName(),
					(cart.get(i).getPrice() / ((double) 100)));
		}

		// Cost information
		ShoppingCart.viewShoppingCart(cart);

		// Payment information
		System.out.printf("\n%-15s %-10s\n", "Payment Type:", "Credit");
		System.out.printf("%-15s %-10s%s\n", "Number:", "xxxx-xxxx-xxxx-", lastFour);

		// Saves order to file for later use
		ReadWriteFiles.writeToFile(cart, super.getSubTotal(), super.getTaxTotal(), super.getGrandTotal(), name);

	}

}
