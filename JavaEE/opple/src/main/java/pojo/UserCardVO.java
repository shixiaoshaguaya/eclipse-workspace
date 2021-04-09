package pojo;

import java.util.Date;

public class UserCardVO extends User {
	String card_id;
	String name;
	Date birthday;
	String card_telephone;
	String address;

	public String getCard_id() {
		return card_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCard_telephone() {
		return card_telephone;
	}

	public void setCard_telephone(String card_telephone) {
		this.card_telephone = card_telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserCardVO [" + super.toString() + ",susucard_id=" + card_id + ", name=" + name + ", birthday="
				+ birthday + ", card_telephone=" + card_telephone + ", address=" + address + "]";
	}
}
