package pay;

import java.util.ArrayList;
import java.util.Scanner;

import products.Product;

public abstract class Payment {
	private int subTotal;
	private double taxTotal;
	private double grandTotal;

	// Constructors
	public Payment() {
		this.subTotal = 0;
		this.taxTotal = 0;
		this.grandTotal = 0;
	}

	public Payment(int subTotal) {
		// Populates all three variables using subtotal
		this.subTotal = subTotal;
		this.taxTotal = (subTotal) * ((double) 0.06);
		this.grandTotal = taxTotal + (double) subTotal;
	}

	// Getters and setters (using just subtotal)
	public int getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}

	public double getTaxTotal() {
		return taxTotal;
	}

	public void setTaxTotal() {
		this.taxTotal = (subTotal) * ((double) 0.06);
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal() {
		this.grandTotal = taxTotal + (double) subTotal;
	}

	// abstract method for a printed receipt
	public abstract void receipt(ArrayList<Product> cart, Scanner sc, String name);

	@Override
	public String toString() {
		return subTotal + "," + taxTotal + "," + grandTotal;
	}

}