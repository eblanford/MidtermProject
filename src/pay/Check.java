package pay;

import java.util.ArrayList;
import java.util.Scanner;

import products.Product;
import utilities.ReadWriteFiles;
import utilities.Validator;

public class Check extends Payment {
	int checkNumber;

	public Check() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Check(int subTotal) {
		super(subTotal);
		// TODO Auto-generated constructor stub
	}

	public int getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(Scanner sc) {
		this.checkNumber = Validator.getInt(sc, "\nPlease provide your check number: ");
	}

	@Override
	public void receipt(ArrayList<Product> cart, Scanner sc) {
		setCheckNumber(sc);

		System.out.printf("%-5s %-30s %-10s\n", "Qty:", "Item", "Amt.");
		System.out.println("------------------------------------");
		for (int i = 0; i < cart.size(); i++) {
			System.out.printf("%-5d %-30s $%-10.2f\n", cart.get(i).getQuantity(), cart.get(i).getName(),
					(cart.get(i).getPrice() / ((double) 100)));
		}

		System.out.printf("\n%-10s $%-10.2f\n", "Subtotal:", (super.getSubTotal() / ((double) 100)));
		System.out.printf("%-10s $%-10.2f\n", "Tax:", super.getTaxTotal() / 100);
		System.out.printf("%-10s $%-10.2f\n", "Grand Total:", super.getGrandTotal() / 100);

		System.out.printf("\n%-10s %-20s\n", "Payment Type:", "Check");
		System.out.printf("%-10s %-20d\n", "Check #:", checkNumber);

		ReadWriteFiles.writeToFile(cart, super.getSubTotal(), super.getTaxTotal(), super.getGrandTotal());

	}


}