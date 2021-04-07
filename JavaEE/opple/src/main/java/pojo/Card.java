package pojo;

import java.util.Date;

public class Card {
	private String id;
	private String name;
	private Date birthday;
	private String telephone;
	private String address;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Card() {
		super();
	}

	public Card(String id, String name, Date birthday, String telephone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.telephone = telephone;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", name=" + name + ", birthday=" + birthday + ", telephone=" + telephone
				+ ", address=" + address + "]";
	}
}
