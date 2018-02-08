package pay;

import java.util.Scanner;

public abstract class Payment {
	
	private double subTotal;
	private double tax;
	private double grandTotal;
	
	
	public Payment(double subTotal) {
		this.subTotal= subTotal/100;
		tax = (subTotal*0.06)/100;
		grandTotal = tax + subTotal;
	}
	
	public void Receipt() {
	
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
	}
	 
	public abstract void pay();
}



