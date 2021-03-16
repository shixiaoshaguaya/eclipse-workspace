package cz0409;

import java.util.HashSet;
import java.util.Iterator;

class Student {
	private String id;
	private String name;

	public Student(String id, String name) {
		this.id = id;
		this.name = name;
	}

	// 重写toString（）方法
	public String toString() {
		return id + ":" + name;
	}

	// 重写hasCode方法
	public int hashCode() {
		return id.hashCode();// 返回id属性的哈希值
	}

	// 重写equals方法
	public boolean equals(Object obj) {
		if (this == obj) {// 判断是否是同一个对象
			return true;// 如果是，直接返回true
		}
		if (!(obj instanceof Student)) {// 判断对象是为Student类型
			return false;// 如果对象不是Student类型，返回false
		}
		Student stu = (Student) obj;// 将对象强转为Student类型
		boolean b = this.id.equals(stu.id);// 判断id值是否相同
		return b;// 返回判断结果
	}
}
public class Hs_Ex {
	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add("郑海彬");
		set.add("沈晓毅");
		set.add("黄志翔");
		set.add("黄焱荣");
		System.out.println(set);
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		HashSet hs = new HashSet();
		Student stu1 = new Student("1", "郑海彬");
		Student stu2 = new Student("2", "黄焱荣");
		Student stu3 = new Student("2", "黄焱荣");
		Student stu4 = new Student("4", "黄志翔");
		hs.add(stu1);
		hs.add(stu2);
		hs.add(stu3);
		hs.add(stu4);
		System.out.println(hs);
	}
}
