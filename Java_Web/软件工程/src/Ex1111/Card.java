package Ex1111;

public class Card {
	private String CardNumber;
	private double Balance;
	private String Password;
	public String getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(String CardNumber) {
		this.CardNumber = CardNumber;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double Balance) {
		this.Balance = Balance;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String Password) {
		this.Password = Password;
	}
	public Card(String CardNumber, double Balance, String Password) {
		super();
		this.CardNumber = CardNumber;
		this.Balance = Balance;
		this.Password = Password;
	}
	public Card() {
		super();
	}
}
