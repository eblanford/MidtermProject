package pay;

import java.util.ArrayList;
import java.util.Scanner;

import products.Product;
import utilities.ReadWriteFiles;

public class CreditCard extends Payment {
	private String exp;
	private long ccNum;
	private String cvv;

	public CreditCard(int subTotal) {
		super(subTotal);
	}

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
	public void receipt(ArrayList<Product> cart, Scanner sc) {

		System.out.println("CreditCard Number: ");
		setCcNum(sc.nextLong());
		sc.nextLine();
		System.out.println("CVV: ");
		setCvv(sc.nextLine());
		System.out.println("Exp date(mm/yy): ");
		setExp(sc.nextLine());
		
		System.out.printf("%-5s %-20s %-10s\n", "Qty:", "Item", "Amt.");
		System.out.println("------------------------------------");
		for (int i = 0; i < cart.size(); i++) {
			System.out.printf("%-5d %-20s $%-10.2f\n", cart.get(i).getQuantity(), cart.get(i).getName(),
					(cart.get(i).getPrice() / ((double) 100)));
		}

		System.out.printf("\n%-10s $%-10.2f\n", "Subtotal:", (super.getSubTotal() / ((double) 100)));
		System.out.printf("%-10s $%-10.2f\n", "Tax:", super.getTaxTotal() / 100);
		System.out.printf("%-10s $%-10.2f\n", "Grand Total:", super.getGrandTotal() / 100);

		System.out.printf("\n%-10s %-20s\n", "Payment Type:", "Credit");
		System.out.printf("%-10s %.4s%s\n", "Credit Card Num:", getCcNum(),"-xxxx-xxxx-xxxx");

		ReadWriteFiles.writeToFile(cart, super.getSubTotal(), super.getTaxTotal(), super.getGrandTotal());


	}

}
