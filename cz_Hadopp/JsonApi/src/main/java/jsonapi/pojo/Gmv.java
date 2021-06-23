package jsonapi.pojo;

import java.util.Date;

public class Gmv {
	private Date dt;
	private int gmv_count;
	private float gmv_amount;
	private float gmv_payment;

	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

	public int getGmv_count() {
		return gmv_count;
	}

	public void setGmv_count(int gmv_count) {
		this.gmv_count = gmv_count;
	}

	public float getGmv_amount() {
		return gmv_amount;
	}

	public void setGmv_amount(float gmv_amount) {
		this.gmv_amount = gmv_amount;
	}

	public float getGmv_payment() {
		return gmv_payment;
	}

	public void setGmv_payment(float gmv_payment) {
		this.gmv_payment = gmv_payment;
	}
}
