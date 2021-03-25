package cn.lmu.ssm.pojo;

public class UserInfo {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public UserInfo() {
		super();
	}

	public UserInfo(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
}
