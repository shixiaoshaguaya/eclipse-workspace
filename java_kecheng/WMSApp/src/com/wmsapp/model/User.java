package com.wmsapp.model;

public class User {
	private String u_Name;
	private String u_Password;
	private String u_Type;

	public String getU_Name() {
		return u_Name;
	}

	public void setU_Name(String u_Name) {
		this.u_Name = u_Name;
	}

	public String getU_Password() {
		return u_Password;
	}

	public void setU_Password(String u_Password) {
		this.u_Password = u_Password;
	}

	public String getU_Type() {
		return u_Type;
	}

	public void setU_Type(String u_Type) {
		this.u_Type = u_Type;
	}

	public User(String u_Name, String u_Password, String u_Type) {
		super();
		this.u_Name = u_Name;
		this.u_Password = u_Password;
		this.u_Type = u_Type;
	}

}
