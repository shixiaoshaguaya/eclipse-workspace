package com.wmsapp.model;

public class Goods {
	private String g_ID;
	private String g_Name;
	private String g_Price;
	private String g_Number;
	private String g_Factory;
	public String getG_ID() {
		return g_ID;
	}
	public void setG_ID(String g_ID) {
		this.g_ID = g_ID;
	}
	public String getG_Name() {
		return g_Name;
	}
	public void setG_Name(String g_Name) {
		this.g_Name = g_Name;
	}
	public String getG_Price() {
		return g_Price;
	}
	public void setG_Price(String g_Price) {
		this.g_Price = g_Price;
	}
	public String getG_Number() {
		return g_Number;
	}
	public void setG_Number(String g_Number) {
		this.g_Number = g_Number;
	}
	public String getG_Factory() {
		return g_Factory;
	}
	public void setG_Factory(String g_Factory) {
		this.g_Factory = g_Factory;
	}
	public Goods(String g_ID, String g_Name, String g_Price, String g_Number, String g_Factory) {
		super();
		this.g_ID = g_ID;
		this.g_Name = g_Name;
		this.g_Price = g_Price;
		this.g_Number = g_Number;
		this.g_Factory = g_Factory;
	}
	
}
