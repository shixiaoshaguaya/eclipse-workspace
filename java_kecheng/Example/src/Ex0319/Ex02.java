package Ex0319;

/*
 * �ӿڵĶ����ʹ��
 */
//������Animal�ӿ�
interface Animal02 {
	// ����ȫ�ֳ�����Ĭ�����η�public static final
	public static final String ANIMAL_BEHAVIOR = "�������Ϊ";

	// ������󷽷�breathe�������η����̶�Ϊpublic abstract
	public abstract void breathe();

	// ������󷽷�run����
	public abstract void run();
}

//����Dog����ʵ��Animal�ӿ�
class Dog02 implements Animal02 {
	// ��д�ӿڳ��󷽷�breathe����
	public void breathe() {
		System.out.println(ANIMAL_BEHAVIOR + ":" + "���ں���");
	}

	// ��д�ӿڳ��󷽷�run����
	public void run() {
		System.out.println(ANIMAL_BEHAVIOR + ":" + "���ڱ���");
	}
}

//���������
public class Ex02 {
	public static void main(String[] args) {
		Dog02 dog = new Dog02();// ����Dog�������Animal�ӿڵ�ʵ����Ķ���
		// ʹ�ö�����.�������ķ�ʽ������ӿ��еĳ���
		// System.out.println(dog.ANIMAL_BEHAVIOR);
		// �ӿ���.�������ķ�ʽ������ӿ��еĳ���
		// System.out.println(Animal.ANIMAL_BEHAVIOR);
		dog.breathe();
		dog.run();
	}
}
