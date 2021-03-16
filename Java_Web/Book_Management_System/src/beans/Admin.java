package beans;

public class Admin {
	private String a_id;// 管理员ID
	private String a_name;// 管理员姓名
	private String a_password;// 管理员密码

	public String getA_id() {
		return a_id;
	}

	public void setA_id(String a_id) {
		this.a_id = a_id;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

	public String getA_password() {
		return a_password;
	}

	public void setA_password(String a_password) {
		this.a_password = a_password;
	}

	public Admin() {
		super();
	}

	public Admin(String a_id, String a_name, String a_password) {
		super();
		this.a_id = a_id;
		this.a_name = a_name;
		this.a_password = a_password;
	}
}
