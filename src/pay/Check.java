package pay;

public class Check extends Payment {
	
	String customerName;
	int routingNumber;
	int checkingNumber;
	
	
	public void Check(String customerName, int routingNumber, int checkingNumber) {
		this.customerName = customerName;
		this.routingNumber = routingNumber;
		this.checkingNumber = checkingNumber;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public int getRoutingNumber() {
		return routingNumber;
	}


	public void setRoutingNumber(int routingNumber) {
		this.routingNumber = routingNumber;
	}


	public int getCheckingNumber() {
		return checkingNumber;
	}


	public void setCheckingNumber(int checkingNumber) {
		this.checkingNumber = checkingNumber;
	}
	

}

