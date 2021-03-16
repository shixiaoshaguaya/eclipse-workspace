package cz0324;

//����Animal�ӿ�
interface Animal {
	// ������󷽷�shout����
	public abstract void shout();
}

//����Cat��ʵ��Animal�ӿ�
class Cat implements Animal {
	// ʵ��shout��������
	public void shout() {
		System.out.println("����...");
	}

	// ����sleep��������
	public void sleep() {
		System.out.println("è˯��...");
	}
}

//���������
public class Ex0324 {
	// ����һ����̬animalShout��Animal an������
	public static void animalShout(Animal an) {
		an.shout();
	}

	public static void main(String[] args) {
		// ����һ���ڲ���Dogʵ��Animal�ӿ�
		class Dog implements Animal {
			// ʵ��shout��������
			public void shout() {
				System.out.println("����...");
			}
		}
		animalShout(new Dog());// ����animalShot���������������
		Cat c1 = new Cat();// ����Cat���ʵ������c1
		animalShout(c1);// ����animalShout��������
		c1.sleep();// ����sleep��������
		System.out.println(c1.toString());// ����toString��������ӡ
	}
}
