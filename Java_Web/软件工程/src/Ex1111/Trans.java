package Ex1111;

public class Trans {
	private int ID;
	private String CardNumber;
	private String TransType;
	private double TransMoney;
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public String getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(String CardNumber) {
		this.CardNumber = CardNumber;
	}
	public String getTransType() {
		return TransType;
	}
	public void setTransType(String TransType) {
		this.TransType = TransType;
	}
	public double getTransMoney() {
		return TransMoney;
	}
	public void setTransMoney(double TransMoney) {
		this.TransMoney = TransMoney;
	}
	public Trans(int ID, String CardNumber, String TransType, double TransMoney){
		super();
		this.ID = ID;
		this.CardNumber = CardNumber;
		this.TransType = TransType;
		this.TransMoney = TransMoney;
	}
}
