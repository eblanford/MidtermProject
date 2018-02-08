package pay;

import java.util.ArrayList;
import java.util.Scanner;

import products.Product;
import utilities.ReadWriteFiles;
import utilities.Validator;

public class Cash extends Payment {
	double inputCash;

	public Cash() {
		super();
		inputCash = 0;
		// TODO Auto-generated constructor stub
	}

	public Cash(int subTotal) {
		super(subTotal);
	}

	public double getInputCash() {
		return inputCash;
	}

	// FIXME make a validator for a double with just a min
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
		
		System.out.printf("%-5s %-30s %-10s\n", "Qty:", "Item", "Amt.");
		System.out.println("------------------------------------");
		for (int i = 0; i < cart.size(); i++) {
			System.out.printf("%-5d %-30s $%-10.2f\n", cart.get(i).getQuantity(), cart.get(i).getName(),
					(cart.get(i).getPrice() / ((double) 100)));
		}

		System.out.printf("\n%-10s $%-10.2f\n", "Subtotal:", (super.getSubTotal() / ((double) 100)));
		System.out.printf("%-10s $%-10.2f\n", "Tax:", super.getTaxTotal() / 100);
		System.out.printf("%-10s $%-10.2f\n", "Grand Total:", super.getGrandTotal() / 100);

		System.out.printf("\n%-10s %-20s\n", "Payment Type:", "Cash");
		System.out.printf("%-10s $%-20.2f\n", "Tendered:", inputCash);
		System.out.printf("%-10s $%-20.2f\n", "Change due:", change);

		ReadWriteFiles.writeToFile(cart, super.getSubTotal(), super.getTaxTotal(), super.getGrandTotal(), name);
	}

	public String toString() {
		return super.getSubTotal() + "," + super.getTaxTotal() + "," + super.getGrandTotal() + "," + inputCash;
	}

}