package pay;

public class CreditCard extends Payment {
	
	private String customerName;
	private int cardNumber;
	private int expDate;
	private int cvvNumber;
	
	public void CreditCard (int cardNumber, int expDate, int cvvNumber) {
		this.cardNumber = cardNumber;
		this.expDate = expDate;
		this.cvvNumber = cvvNumber;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getExpDate() {
		return expDate;
	}

	public void setExpDate(int expDate) {
		this.expDate = expDate;
	}

	public int getCvvNumber() {
		return cvvNumber;
	}

	public void setCvvNumber(int cvvNumber) {
		this.cvvNumber = cvvNumber;
	}

}
