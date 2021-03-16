package cz0303;

class Person {
	int age;// 定义int类型的变量age
	// 定义 speak（）方法

	public void speak() {
		System.out.println("大家好，我今年" + age + "岁");
	}

	// 创建say()方法，输出一句话“我是一个人”
	public void say() {
		System.out.println("我是一个人！");
	}
}

public class Ex301 {
	public static void main(String[] args) {
		Person p1 = new Person();// 创建第一个Person对象
		Person p2 = new Person();// 创建第二个Person对象
		p1.age = 44;// 为p1的age属性赋值
		p1.speak();// p1调用对象的speak方法
		p1.say();// p1调用say()方法
		p2.speak();// p2调用对象的speak方法
		p2.say();// p2调用say()方法
	}
}
