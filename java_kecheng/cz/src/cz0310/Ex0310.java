package cz0310;

//定义Person类表示人
class Person {
	// 为Person类定义String型的name（姓名）和int型的age（年龄）的成员变量
	String name;
	int age;

	// 为name和age分别定义访问方法和修改方法
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String setName) {
		name = setName;
	}

	public void setAge(int setAge) {
		age = setAge;
	}

	// 为Person定义构造方法
	public Person() {
		return;
	}

	public Person(String name) {
		this.name = name;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// 为Person定义toString（）的方法
	public String toString() {
		return "姓名=" + name + ",年龄=" + age;
	}

	// 定义一个void Speak（）的成员方法，该方法带一个String型的name（姓名）参数，方法的作用是输出name值
	public void Speak(String name) {
		System.out.println("大家好，我叫" + name + "。");
	}

	// 定义一个void
	// Speak（）的成员方法，该方法带一个String型的name（姓名）和一个int型的age（年龄）参数，方法的作用是输出name和age值
	public void Speak(String name, int age) {
		System.out.println("大家好，我叫" + name + "，今年" + age + "岁了！");
	}

	// 定义一个void
	// Speak（）的成员方法，该方法带一个String型的name（姓名）、一个String型的sex（性别）和一个int型的age（年龄）参数，方法的作用是输出name、sex和age值
	public void Speak(String name, String sex, int age) {
		System.out.println("大家好，我叫" + name + "，是" + sex + "，今年" + age + "岁了！");
	}
}

//测试以上所有构造方法和成员方法
public class Ex0310 {
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person("陈喆");
		Person p3 = new Person("陈喆", 21);
		System.out.println("第一位：" + p1.toString());
		System.out.println("第二位：" + p2.toString());
		System.out.println("第三位：" + p3.toString());
		p1.Speak("陈喆");
		p1.Speak("陈喆", 21);
		p1.Speak("陈喆", "男生", 21);
	}
}
