package com.wmsapp.model;

public class Staff {
	private String s_ID;
	private String s_Name;
	private String s_Address;
	private String s_Gender;
	private String s_Telephone;

	public String getS_ID() {
		return s_ID;
	}

	public void setS_ID(String s_ID) {
		this.s_ID = s_ID;
	}

	public String getS_Name() {
		return s_Name;
	}

	public void setS_Name(String s_Name) {
		this.s_Name = s_Name;
	}

	public String getS_Address() {
		return s_Address;
	}

	public void setS_Address(String s_Address) {
		this.s_Address = s_Address;
	}

	public String getS_Gender() {
		return s_Gender;
	}

	public void setS_Gender(String s_Gender) {
		this.s_Gender = s_Gender;
	}

	public String getS_Telephone() {
		return s_Telephone;
	}

	public void setS_Telephone(String s_Telephone) {
		this.s_Telephone = s_Telephone;
	}

	public Staff(String s_ID, String s_Name, String s_Address, String s_Gender, String s_Telephone) {
		super();
		this.s_ID = s_ID;
		this.s_Name = s_Name;
		this.s_Address = s_Address;
		this.s_Gender = s_Gender;
		this.s_Telephone = s_Telephone;
	}
}
