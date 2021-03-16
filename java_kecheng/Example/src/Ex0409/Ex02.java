package Ex0409;

import java.util.*;

class Student01 {
	String id;
	String name;

	public Student01(String id, String name) {// 创建构造方法
		this.id = id;
		this.name = name;
	}

	public String toString() {// 重写toString（）方法
		return id + ":" + name;
	}
}

public class Ex02{
	public static void main(String[] args) {
		HashSet hs = new HashSet();// 创建HashSet集合
		Student01 stu1 = new Student01("1", "Jack");// 创建Student对象
		Student01 stu2 = new Student01("2", "Rose");
		Student01 stu3 = new Student01("2", "Rose");
		hs.add(stu1);
		hs.add(stu2);
		hs.add(stu3);
		System.out.println(hs);
	}
}
