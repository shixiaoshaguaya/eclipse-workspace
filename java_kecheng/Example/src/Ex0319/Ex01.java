package Ex0319;

/*
 * �������ʹ��
 */
//���������Animal
abstract class Animal01 {
	public abstract void shout();
}

//����Dog��̳�Animal������
class Dog01 extends Animal01 {
	// ��д����ĳ��󷽷���ʵ�ֳ��󷽷�
	public void shout() {
		System.out.println("����...");
	}
}

//����Ĳ�����
public class Ex01 {
	public static void main(String[] args) {
		Dog01 dog = new Dog01();// ����Dog��Ķ��󣬴������ǳ�������������
		dog.shout();
	}
}
