package pay;

import java.util.Scanner;

public class Cash extends Payment {
Scanner scan = new Scanner(System.in);
	private double tenderedAmt;
	private double subTotal;
	private double tax;
	private double grandTotal;
	
	public Cash(double subTotal,double tenderedAmt) {
		super(subTotal);
		this.tax = (subTotal*0.06)/100;
		this.grandTotal = tax + subTotal;
		this.tenderedAmt = tenderedAmt;

		
	}

	public double getTenderedAmt() {
		return tenderedAmt;
	}

	public void setTenderedAmt(int tenderedAmt) {
		this.tenderedAmt = tenderedAmt;
	}

	@Override
	public void pay() {
		System.out.println("Cash tendered: ");
		tenderedAmt=scan.nextDouble();
		double change = tenderedAmt - grandTotal;
		System.out.println("Change: "+ change);
		
		
		
		
	}
	
	}