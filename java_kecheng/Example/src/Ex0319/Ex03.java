package Ex0319;

/*
 * �ӿ�֮��ļ̳�
 */
//������Animal�ӿ�
interface Animal03 {
	// ����ȫ�ֳ�����Ĭ�����η�public static final
	public static final String ANIMAL_BEHAVIOR = "�������Ϊ";

	// ������󷽷�breathe�������η����̶�Ϊpublic abstract
	public abstract void breathe();

	// ������󷽷�run����
	public abstract void run();
}

//����ӿ�LandAnimal���̳�Animal�ӿ�
interface LandAnimal03 extends Animal03 {
	public abstract void liveOnLand();
}

//����Dog����ʵ��Animal�ӿ�
class Dog03 implements LandAnimal03 {
	// ��д�ӿڳ��󷽷�breathe����
	public void breathe() {
		System.out.println(ANIMAL_BEHAVIOR + ":" + "���ں���");
	}

	// ��д�ӿڳ��󷽷�run����
	public void run() {
		System.out.println(ANIMAL_BEHAVIOR + ":" + "���ڱ���");
	}

	// ��д�ӿڳ��󷽷�liveOnLand����
	public void liveOnLand() {
		System.out.println("����½���ϵĶ���");
	}
}

//���������
public class Ex03 {
	public static void main(String[] args) {
		Dog03 dog = new Dog03();// ����Dog�������Animal�ӿڵ�ʵ����Ķ���
		// ʹ�ö�����.�������ķ�ʽ������ӿ��еĳ���
		// System.out.println(dog.ANIMAL_BEHAVIOR);
		// �ӿ���.�������ķ�ʽ������ӿ��еĳ���
		// System.out.println(Animal.ANIMAL_BEHAVIOR);
		dog.breathe();
		dog.run();
		dog.liveOnLand();
	}
}
