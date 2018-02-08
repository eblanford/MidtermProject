package pay;

import java.util.ArrayList;
import java.util.Scanner;

import products.Product;

public abstract class Payment {
	int subTotal;
	double taxTotal;
	double grandTotal;

	public Payment() {
		this.subTotal = 0;
		this.taxTotal = 0;
		this.grandTotal = 0;
	}

	public Payment(int subTotal) {
		this.subTotal = subTotal;
		this.taxTotal = (subTotal) * ((double) 0.06);
		this.grandTotal = taxTotal + (double) subTotal;
	}

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

	public abstract void receipt(ArrayList<Product> cart, Scanner sc);

	public String toString() {
		return subTotal + "," + taxTotal + "," + grandTotal;
	}

}