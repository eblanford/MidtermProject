package pay;

public abstract class Pay {
	
	private int subTotal;
	private int tax;
	private int grandTotal;
	
	
	public void Payment() {
	
	}
	
	public void Receipt() {
	
	}

	public int getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(int grandTotal) {
		this.grandTotal = grandTotal;
	}
	 
	
}



