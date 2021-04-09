package pojo;

import java.util.Date;
import java.util.List;

public class User {
	private int id;
	private String username;
	private String password;
	private String telephone;
	private String role;
	private Date registertime;
	private Card card;
	private List<Order> orderlist;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getRegistertime() {
		return registertime;
	}

	public void setRegistertime(Date registertime) {
		this.registertime = registertime;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public User() {
		super();
	}

	public User(int id, String username, String password, String telephone, String role, Date registertime, Card card) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.telephone = telephone;
		this.role = role;
		this.registertime = registertime;
		this.card = card;

	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", telephone=" + telephone
				+ ", role=" + role + ", registertime=" + registertime + ", card=" + card + ", orderlist=" + orderlist
				+ "]";
	}

}
