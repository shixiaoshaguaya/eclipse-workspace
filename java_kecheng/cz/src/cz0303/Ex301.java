package cz0303;

class Person {
	int age;// ����int���͵ı���age
	// ���� speak��������

	public void speak() {
		System.out.println("��Һã��ҽ���" + age + "��");
	}

	// ����say()���������һ�仰������һ���ˡ�
	public void say() {
		System.out.println("����һ���ˣ�");
	}
}

public class Ex301 {
	public static void main(String[] args) {
		Person p1 = new Person();// ������һ��Person����
		Person p2 = new Person();// �����ڶ���Person����
		p1.age = 44;// Ϊp1��age���Ը�ֵ
		p1.speak();// p1���ö����speak����
		p1.say();// p1����say()����
		p2.speak();// p2���ö����speak����
		p2.say();// p2����say()����
	}
}
