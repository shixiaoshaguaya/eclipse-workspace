package cz0414;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Student {
	private String id;
	private String name;

	public Student(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return id + ":" + name;
	}

	public int hashCode() {
		return id.hashCode();
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Student)) {
			return false;
		}
		Student stu = (Student) obj;
		boolean b = this.id.equals(stu.id);
		return b;
	}
}
public class Ex0414 {
	public static void main(String[] args) {
		Student stu1 = new Student("1", "֣����");
		Student stu2 = new Student("2", "������");
		Student stu3 = new Student("3", "������");
		Student stu4 = new Student("4", "��־��");
		ArrayList list = new ArrayList();
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		list.add(stu4);
		System.out.println("ArrayList���ϣ�" + list);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		HashSet hs = new HashSet();
		hs.add(stu1);
		hs.add(stu2);
		hs.add(stu3);
		hs.add(stu4);
		System.out.println("HashSet���ϣ�" + hs);
		HashMap map = new HashMap();
		map.put("1", "֣����");
		map.put("2", "������");
		map.put("3", "������");
		map.put("4", "��־��");
		System.out.println("HashMap���ϣ�"+map);
		Set keySet = map.keySet();
		Iterator it1 = keySet.iterator();
		while (it1.hasNext()) {
			Object key = it1.next();
			Object value = map.get(key);
			System.out.println(key + ":" + value);
		}
		HashSet<Student> hs1 = new HashSet<Student>();
		hs1.add(stu1);
		hs1.add(stu2);
		hs1.add(stu3);
		hs1.add(stu4);
		System.out.println("HashSetfan���ͣ�" + hs1);
	}
}
