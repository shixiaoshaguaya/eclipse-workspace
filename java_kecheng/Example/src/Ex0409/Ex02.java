package Ex0409;

import java.util.*;

class Student01 {
	String id;
	String name;

	public Student01(String id, String name) {// �������췽��
		this.id = id;
		this.name = name;
	}

	public String toString() {// ��дtoString��������
		return id + ":" + name;
	}
}

public class Ex02{
	public static void main(String[] args) {
		HashSet hs = new HashSet();// ����HashSet����
		Student01 stu1 = new Student01("1", "Jack");// ����Student����
		Student01 stu2 = new Student01("2", "Rose");
		Student01 stu3 = new Student01("2", "Rose");
		hs.add(stu1);
		hs.add(stu2);
		hs.add(stu3);
		System.out.println(hs);
	}
}
