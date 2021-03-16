package cz0310;

//����Person���ʾ��
class Person {
	// ΪPerson�ඨ��String�͵�name����������int�͵�age�����䣩�ĳ�Ա����
	String name;
	int age;

	// Ϊname��age�ֱ�����ʷ������޸ķ���
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

	// ΪPerson���幹�췽��
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

	// ΪPerson����toString�����ķ���
	public String toString() {
		return "����=" + name + ",����=" + age;
	}

	// ����һ��void Speak�����ĳ�Ա�������÷�����һ��String�͵�name�����������������������������nameֵ
	public void Speak(String name) {
		System.out.println("��Һã��ҽ�" + name + "��");
	}

	// ����һ��void
	// Speak�����ĳ�Ա�������÷�����һ��String�͵�name����������һ��int�͵�age�����䣩���������������������name��ageֵ
	public void Speak(String name, int age) {
		System.out.println("��Һã��ҽ�" + name + "������" + age + "���ˣ�");
	}

	// ����һ��void
	// Speak�����ĳ�Ա�������÷�����һ��String�͵�name����������һ��String�͵�sex���Ա𣩺�һ��int�͵�age�����䣩���������������������name��sex��ageֵ
	public void Speak(String name, String sex, int age) {
		System.out.println("��Һã��ҽ�" + name + "����" + sex + "������" + age + "���ˣ�");
	}
}

//�����������й��췽���ͳ�Ա����
public class Ex0310 {
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person("��");
		Person p3 = new Person("��", 21);
		System.out.println("��һλ��" + p1.toString());
		System.out.println("�ڶ�λ��" + p2.toString());
		System.out.println("����λ��" + p3.toString());
		p1.Speak("��");
		p1.Speak("��", 21);
		p1.Speak("��", "����", 21);
	}
}
