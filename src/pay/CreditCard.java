package pay;

public class CreditCard extends Payment {
	
	private String name;
	private int cardNumber;
	private int expDate;
	private int cvvNumber;
	
	public void CreditCard (String name,int cardNumber, int expDate, int cvvNumber) {
		this.name=name;
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

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		
	}

}
