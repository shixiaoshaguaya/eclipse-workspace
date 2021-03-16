package javabean;

public class Student {
	private String sid;
	private String name;
	private int age;
	private boolean married;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	public String getSid() {
		return sid;
	}
	public String getName() {
		return name;
	}
	public void getInfo() {
		System.out.print("我是一个学生");
	}
}
