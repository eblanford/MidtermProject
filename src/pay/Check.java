package pay;

import java.util.ArrayList;
import java.util.Scanner;

import products.Product;
import utilities.ReadWriteFiles;
import utilities.Validator;

public class Check extends Payment {
	long checkNumber;

	public Check() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Check(int subTotal) {
		super(subTotal);
		// TODO Auto-generated constructor stub
	}

	public long getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(Scanner sc) {
		this.checkNumber = Validator.getLong(sc, "\nWhat is your check number? ", 0l);
	}

	@Override
	public void receipt(ArrayList<Product> cart, Scanner sc, String name) {
		setCheckNumber(sc);

		System.out.printf("\n%-5s %-30s %-10s\n", "Qty:", "Item", "Amt.");
		System.out.println("--------------------------------------------");
		for (int i = 0; i < cart.size(); i++) {
			System.out.printf("%-5d %-30s $%-10.2f\n", cart.get(i).getQuantity(), cart.get(i).getName(),
					(cart.get(i).getPrice() / ((double) 100)));
		}

		System.out.printf("\n%-10s $%-10.2f\n", "Subtotal:", (super.getSubTotal() / ((double) 100)));
		System.out.printf("%-10s $%-10.2f\n", "Tax:", super.getTaxTotal() / 100);
		System.out.printf("%-10s $%-10.2f\n", "Grand Total:", super.getGrandTotal() / 100);

		System.out.printf("\n%-10s %-20s\n", "Payment Type:", "Check");
		System.out.printf("%-10s %-20d\n", "Check #:", checkNumber);

		ReadWriteFiles.writeToFile(cart, super.getSubTotal(), super.getTaxTotal(), super.getGrandTotal(), name);

	}


}