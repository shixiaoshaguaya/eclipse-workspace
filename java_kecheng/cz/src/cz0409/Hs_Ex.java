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

	// ��дtoString��������
	public String toString() {
		return id + ":" + name;
	}

	// ��дhasCode����
	public int hashCode() {
		return id.hashCode();// ����id���ԵĹ�ϣֵ
	}

	// ��дequals����
	public boolean equals(Object obj) {
		if (this == obj) {// �ж��Ƿ���ͬһ������
			return true;// ����ǣ�ֱ�ӷ���true
		}
		if (!(obj instanceof Student)) {// �ж϶�����ΪStudent����
			return false;// ���������Student���ͣ�����false
		}
		Student stu = (Student) obj;// ������ǿתΪStudent����
		boolean b = this.id.equals(stu.id);// �ж�idֵ�Ƿ���ͬ
		return b;// �����жϽ��
	}
}
public class Hs_Ex {
	public static void main(String[] args) {
		HashSet set = new HashSet();
		set.add("֣����");
		set.add("������");
		set.add("��־��");
		set.add("������");
		System.out.println(set);
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		HashSet hs = new HashSet();
		Student stu1 = new Student("1", "֣����");
		Student stu2 = new Student("2", "������");
		Student stu3 = new Student("2", "������");
		Student stu4 = new Student("4", "��־��");
		hs.add(stu1);
		hs.add(stu2);
		hs.add(stu3);
		hs.add(stu4);
		System.out.println(hs);
	}
}
