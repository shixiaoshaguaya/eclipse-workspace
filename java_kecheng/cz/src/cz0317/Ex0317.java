package cz0317;

class Animal {
	String name;// ����String�͵�name����

	// ����Animal���޲ι��췽��
	public Animal() {
		System.out.println("����һֻ����");
	}

	// ����Animal���вι��췽��
	public Animal(String name) {
		System.out.println("����һֻ" + name);
	}

	// ���嶯��еķ���shout����
	public void shout() {
		System.out.println("���﷢������");
	}
}

//����Dog��̳�Animal��
class Dog extends Animal {
	// ����һ����ӡname���Եķ���printName����
	public void printName() {
		System.out.println("name=" + name);
	}

	// ��д�����shout��������
	public void shout() {
		System.out.println("������...");
	}

	// ����Dog���޲ι��췽��
	public Dog() {
		super("ɳƤ��");
	}

	// ����Dog���вι��췽��
	public Dog(String name) {
		super(name);
	}
}

//���������Ex0317
public class Ex0317 {
	public static void main(String[] args) {
		Dog d1 = new Dog();
		// d1.name = "ɳƤ��";
		d1.printName();
		d1.shout();
		Dog d2 = new Dog("����");
		d2.shout();
	}
}
