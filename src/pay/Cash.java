package pay;

public class Cash extends Payment {

	int tenderedAmt;
	int total;
	int cashBack;
	int receipt;
	
	public void Cash(int tenderedAmt, int total, int cashBack, int receipt) {
		this.tenderedAmt = tenderedAmt;
		this.total = total;
		this.cashBack = cashBack;
		this.receipt = receipt;
		
	}

	public int getTenderedAmt() {
		return tenderedAmt;
	}

	public void setTenderedAmt(int tenderedAmt) {
		this.tenderedAmt = tenderedAmt;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCashBack() {
		return cashBack;
	}

	public void setCashBack(int cashBack) {
		this.cashBack = cashBack;
	}

	public int getReceipt() {
		return receipt;
	}

	public void setReceipt(int receipt) {
		this.receipt = receipt;
	}

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		
	}
	
	}