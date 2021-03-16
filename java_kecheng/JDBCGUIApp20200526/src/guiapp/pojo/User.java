package guiapp.pojo;

public class User {// 表示用户的类
	private String name;
	private String password;
	private String telephone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public User() {
		super();
	}

	public User(String name, String password, String telephone) {
		super();
		this.name = name;
		this.password = password;
		this.telephone = telephone;
	}
}
