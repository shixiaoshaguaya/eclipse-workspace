package Ex0317;

/*
 * ����̳и���󣬷�����д
 * ������д���෽��:��֤�����Ȩ�ޱ�����ڻ��ߵ��ڸ��෽��Ȩ��
 */
//����Animal��Ϊ����
class Animal02 {
	// ���嶯��з���
	void shout() {
		System.out.println("���﷢������");
	}
}

//����Dog��̳ж�����
class Dog02 extends Animal02 {
	// ���幷�еķ���
	void shout() {
		System.out.println("������...");
	}
}

//���������
public class Ex02 {
	public static void main(String[] args) {
		Dog02 dog = new Dog02();// ����Dog��Ķ����������
		dog.shout();// ����Dog����д�ĸ��෽��shout
	}
}
